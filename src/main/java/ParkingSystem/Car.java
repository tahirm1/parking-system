/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ParkingSystem;

import java.io.Serializable;

/**
 *
 * @author mariatahir
 */
public class Car implements Serializable {

    private CarType type;
    private String licensePlate;
    private Customer owner;

    public Car() {
        this.type = null;
        this.licensePlate = null;
        this.owner = null;
    }

    public Car(CarType type, String licensePlate, Customer owner) {
        this.type = type;
        this.licensePlate = licensePlate;
        this.owner = owner;
    }

    public CarType getType() {
        return type;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public Customer getOwner() {
        return owner;
    }

    //Fixme: Temporary constructors for testing ParkingGUI
    public Car(String liencesePlate, Customer owner) {
        this.licensePlate = liencesePlate;
        this.owner = owner;
        this.type = CarType.COMPACT;
    }

}
