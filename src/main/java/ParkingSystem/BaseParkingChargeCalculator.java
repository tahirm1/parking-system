/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ParkingSystem;

import ParkingSystem.ParkingChargeCalculator;
import ParkingSystem.ParkingEvent;
import java.io.Serializable;

/**
 *
 * @author mariatahir
 */
public class BaseParkingChargeCalculator implements ParkingChargeCalculator, Serializable {

    @Override
    public Double getDiscount(ParkingEvent parkingEvent) {
        return 0.0;
    }

}
