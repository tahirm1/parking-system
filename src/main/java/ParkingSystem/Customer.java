/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ParkingSystem;

import java.io.Serializable;
import java.util.UUID;

/**
 *
 * @author mariatahir
 */
public final class Customer implements Serializable {

    private final String id;
    private final String firstName;
    private final String lastName;
    private final String phoneNumber;
    private final Address address;

    public Customer(String id, String firstName, String lastName, String phoneNumber, Address address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    //Fixme:this is a temporary method to test ParkingGUI
    public Customer(String firstName, String lastName, String phoneNumber, Address address) {
        this.id = generateId();
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    //Fixme:this is a temporary method to test ParkingGUI
    private String generateId() {
        int max = 100;
        int min = 1;
        int idNumber = min + (int) (Math.random() * ((max - min) + 1));
        return "CUS" + idNumber;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Address getAddress() {
        return address;
    }

    public String getCustomerName() {
        String str = String.format("%s %s", firstName, lastName);
        return str;
    }

}
