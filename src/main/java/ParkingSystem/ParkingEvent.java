/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ParkingSystem;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *
 * @author mariatahir
 */
public class ParkingEvent implements Serializable {

    private final ParkingLot parkingLot;
    private final LocalDateTime timeIn;
    private final LocalDateTime timeOut;
    private final ParkingPermit permit;

    public ParkingEvent(ParkingLot parkingLot, LocalDateTime timeIn, LocalDateTime timeOut, ParkingPermit permit) {
        this.parkingLot = parkingLot;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
        this.permit = permit;
    }

    public ParkingEvent(ParkingLot parkingLot, LocalDateTime timeIn, ParkingPermit permit) {
        this.parkingLot = parkingLot;
        this.timeIn = timeIn;
        this.timeOut = null;
        this.permit = permit;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public LocalDateTime getTimeIn() {
        return timeIn;
    }

    public LocalDateTime getTimeOut() {
        return timeOut;
    }

    public ParkingPermit getPermit() {
        return permit;
    }

}
