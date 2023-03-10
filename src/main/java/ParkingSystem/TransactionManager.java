/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ParkingSystem;

import ParkingSystem.Customer;
import ParkingSystem.Money;
import ParkingSystem.ParkingLot;
import ParkingSystem.ParkingPermit;
import ParkingSystem.ParkingTransaction;
import ParkingSystem.DiscountStrategy;
import ParkingSystem.ParkingEvent;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import ParkingSystem.ParkingObserver;

/**
 *
 * @author mariatahir
 */
public class TransactionManager implements ParkingObserver{

    private List<ParkingTransaction> transactions = new ArrayList<>();

    public TransactionManager() {
    }

    @Override
    public void onParkingEventReceived(ParkingEvent event) {
        this.park(event);
    }

    public ParkingTransaction park(ParkingEvent event) {
        Money chargeAmount = event.getParkingLot().getParkingCharge(event);
        ParkingTransaction transaction;
        if (event.getTimeOut() == null) {
            transaction = new ParkingTransaction(event.getTimeIn(), event.getPermit(), event.getParkingLot(), chargeAmount);
        } else {
            transaction = new ParkingTransaction(event.getTimeOut(), event.getPermit(), event.getParkingLot(), chargeAmount);
        }
        System.out.println(String.format("Transaction %s for %s car at parkingLot %s created", transaction.getChargedAmount(), event.getPermit().getCar().getType(), event.getParkingLot().getName()));
        return transaction;

    }

    // Method calculate amount charged and create new parking transaction
    public ParkingTransaction park(LocalDateTime date, ParkingPermit parkingPermit, ParkingLot parkingLot) {
        Money chargedAmount;
        chargedAmount = parkingLot.getFixedDailyRate(); // 10 USD
        ParkingTransaction transaction = new ParkingTransaction(date, parkingPermit, parkingLot, chargedAmount);
        transactions.add(transaction);
        System.out.println("New transaction created");
        return transaction;
    }

    //calculate total parking charges for a parkingpermit
    public Money getParkingCharges(ParkingPermit parkingPermit) {
        //Get all parking transactions of which date is within the current month of current year
        List<ParkingTransaction> currentMonthlyTransactions = new ArrayList<>();
        Month currentMonth = LocalDateTime.now().getMonth();
        int currentYear = LocalDateTime.now().getYear();
        for (int i = 0; i < transactions.size(); i++) {
            if (transactions.get(i).getDate().getMonth().equals(currentMonth)
                    && transactions.get(i).getDate().getYear() == currentYear) {
                currentMonthlyTransactions.add(transactions.get(i));
            }
        }
        long sumCharges = 0;
        for (int i = 0; i < currentMonthlyTransactions.size(); i++) {
            if (currentMonthlyTransactions.get(i).getPermit().equals(parkingPermit)) {
                Money charge = currentMonthlyTransactions.get(i).getChargedAmount();
                sumCharges += charge.getAmount();
            }
        }

        Money total = new Money(sumCharges);
        return total;
    }

    public Money getParkingCharges(Customer customer) {
        //Get all parking transactions of which date is within the current month of current year
        List<ParkingTransaction> currentMonthlyTransactions = new ArrayList<>();
        Month currentMonth = LocalDateTime.now().getMonth();
        int currentYear = LocalDateTime.now().getYear();
        for (int i = 0; i < transactions.size(); i++) {
            if (transactions.get(i).getDate().getMonth().equals(currentMonth)
                    && transactions.get(i).getDate().getYear() == currentYear) {
                currentMonthlyTransactions.add(transactions.get(i));
            }
        }
        long sumCharges = 0;
        for (int i = 0; i < currentMonthlyTransactions.size(); i++) {
            if (currentMonthlyTransactions.get(i).getPermit().getCar().getOwner().equals(customer)) {
                Money charge = currentMonthlyTransactions.get(i).getChargedAmount();
                sumCharges += charge.getAmount();
            }
        }
        Money total = new Money(sumCharges);
        return total;
    }

}