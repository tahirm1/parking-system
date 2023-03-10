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
public final class ParkingPermit implements Serializable {
    private final String id;
    private final Car car;
    private final LocalDateTime expiration;
    private boolean isScanned = false;

    //Fixme:this is a temporary method to test ParkingGUI
    public ParkingPermit(String liecensePlate, Car car) {
        this.id = generateId(liecensePlate);
        this.car = car;
        this.expiration = LocalDateTime.now().plusYears(1);
    }
 
    //Fixme:this is a temporary method to test ParkingGUI
    public String generateId(String licensePlate){
        return "PRM" + licensePlate;
    }

    public Car getCar() {
        return car;
    }
    
    public String getId() {
        return id;
    }
    
    public boolean isExpired(){
        if (LocalDateTime.now().isAfter(expiration)){
            return true;
        }
        return false;
    }
    
}

