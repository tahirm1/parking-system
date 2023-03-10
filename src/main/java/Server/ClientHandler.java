/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Server;

import Client.ResponseData;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mariatahir
 */
public class ClientHandler implements Runnable {
    private Socket client;
    private ParkingService service; 

    private static final Logger logger = Logger.getLogger(Server.class.getName());

    public ClientHandler(Socket s, ParkingService service) {
        client = s;
        this.service = service;
    }

    @Override
    public void run() {
        try {

            ObjectOutputStream os = new ObjectOutputStream(client.getOutputStream());
            InputStream isw = client.getInputStream();

            ResponseData output;
            try {
                synchronized (service) {
                    output = service.handleInput(isw);
                }
            } 
            catch (Exception ex) {
                output = new ResponseData(false, ex.getMessage(), null);
            }
            
            os.writeObject(output);
            os.flush();
        } 
        catch (IOException e) {
            logger.log(Level.WARNING, "Failed to read from client.", e);
        } 
        finally {
            try {
                client.close();
            } 
            catch (IOException e) {
                logger.log(Level.WARNING, "No data received", e);
            }
        }
    }
}