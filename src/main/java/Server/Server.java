/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Server;

import Client.Command;
import Client.ResponseData;
import ParkingSystem.Address;
import static ParkingSystem.Main.WEEKDAY_CARTYPE_DISCOUNT;
import static ParkingSystem.Main.WEEKDAY_DISCOUNT;
import ParkingSystem.ParkingChargeCalculatorFactory;
import ParkingSystem.ParkingLot;
import ParkingSystem.ParkingOffice;
import ParkingSystem.PermitManager;
import ParkingSystem.TransactionManager;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang3.SerializationUtils;

/**
 *
 * @author mariatahir
 */
public class Server {

    static {
        System.setProperty(
                "java.util.logging.SimpleFormatter.format", "%1$tc %4$-7s (%2$s) %5$s %6$s%n");
    }

    private static final Logger logger = Logger.getLogger(Server.class.getName());

    private final int PORT = 7777;

    private final ParkingService service;
    
    // Week 9 addition 
    
    private Duration cumulativeDuration = Duration.ZERO;

    private int connectionCount = 0;

    private static volatile boolean doContinue = true;

    public static void stopServer() {
        doContinue = false;
        Thread.currentThread().interrupt();
    }

    public Server(ParkingService service) {
        this.service = service;
    }

    public void startServer() throws IOException {
        logger.info("Starting server: " + InetAddress.getLocalHost().getHostAddress());
        try ( ServerSocket serverSocket = new ServerSocket(PORT)) {
            serverSocket.setReuseAddress(true);
            while (true) {
                Socket client = serverSocket.accept();
                handleClient(client);
                
                //week 9 addition 
                
                Instant start = Instant.now();

                Runnable r = new ClientHandler(client, getService());
                new Thread(r).start();

                Instant done = Instant.now();

                cumulativeDuration = cumulativeDuration.plus(Duration.between(start, done));
                connectionCount++;
            }

            //  System.out.println(getConnectionStatistics());
            System.out.println("Handled " + connectionCount + " connections in " + cumulativeDuration);
            if (connectionCount > 0) {
                System.out.println("    "
                        + (cumulativeDuration.toNanos() / connectionCount)
                        + " ns. per connection");
                
            }
        }
    }

    private void handleClient(Socket client) {
        try {
            // Using os to return output to client
            ObjectOutputStream os = new ObjectOutputStream(client.getOutputStream());
            ResponseData output;
            try {
                // Process requestData from client and return output as responseData
                output = service.handleInput(client.getInputStream());
            } catch (RuntimeException ex) {
                ex.printStackTrace();
                output = new ResponseData(false, ex.getLocalizedMessage(), null);
            }

            os.writeObject(output);
            os.flush();

        } catch (Exception e) {
            logger.log(Level.WARNING, "Failed to read from client.", e);
        } finally {
            try {
                client.close();
            } catch (IOException e) {
                logger.log(Level.WARNING, "Failed to close client socket.", e);
            }
        }
    }

    /**
     * 
     */
    public static void main(String[] args) throws Exception {
//    ParkingOffice parkingOffice = new ParkingOffice("Office", new Address());

        Address parkingOfficeAddress = new Address("20 Joseph Street", "South Iris", "Bronx", "NY", "");
        TransactionManager transactionManager = new TransactionManager();
        PermitManager permitManager = new PermitManager();
        ParkingOffice parkingOffice = new ParkingOffice("Main Office", parkingOfficeAddress, transactionManager, permitManager);
        ParkingService service = new ParkingService(parkingOffice);

        ParkingChargeCalculatorFactory parkingChargeCalculatorFactory = new ParkingChargeCalculatorFactory();

        //Create parking Lot A with WeekdayDiscount
        Address parkingLotAddressA = new Address("214 CherryCreek", "Broomfield", "Bronx", "CO", "");
        ParkingLot parkingLotA = new ParkingLot("1", "Lot A", parkingLotAddressA, WEEKDAY_DISCOUNT, parkingChargeCalculatorFactory);
        System.out.println(String.format("Parking lot %s applies %s", parkingLotA.getName(), parkingLotA.getDiscountStrategy()));

        //Create parking Lot B with WeekdayCarTypeDiscount
        Address parkingLotAddressB = new Address("111 University Blvd", "Littelton", "Denver", "Co", "");
        ParkingLot parkingLotB = new ParkingLot("2", "Lot B", parkingLotAddressB, WEEKDAY_CARTYPE_DISCOUNT, parkingChargeCalculatorFactory);
        System.out.println(String.format("Parking lot %s applies %s", parkingLotB.getName(), parkingLotB.getDiscountStrategy()));

        //Create parking Lot C with No Discount
        Address parkingLotAddressC = new Address("121 University Blvd", "Littelton", "Denver", "Co", "");
        ParkingLot parkingLotC = new ParkingLot("3", "Lot C", parkingLotAddressC, parkingChargeCalculatorFactory);
        System.out.println("Parking lot Lot C does not apply discount strategy");

        parkingOffice.addParkingLot(parkingLotA);
        parkingOffice.addParkingLot(parkingLotB);
        parkingOffice.addParkingLot(parkingLotC);

        new Server(service).startServer();
    }
}
