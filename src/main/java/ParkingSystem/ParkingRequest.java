/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ParkingSystem;

import java.io.*;
import java.util.*;

/**
 *
 * @author mariatahir
 */
public class ParkingRequest implements Serializable {

    private int permitNumber;
    private String commandName;

    ParkingRequest(int num, String name) {
        permitNumber = num;
        commandName = name;
    }

    public int getPermitNumber() {
        return permitNumber;
    }

    public void setPermitNumber(int num) {
        permitNumber = num;
    }

    public String getCommandName() {
        return commandName;
    }

    public void setCommandName(String name) {
        commandName = name;
    }

}
