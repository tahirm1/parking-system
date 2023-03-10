/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ParkingSystem;

import parkingsystem.ParkingEvent;

/**
 *
 * @author mariatahir
 */
public interface ParkingChargeCalculator {
    public Double getDiscount(ParkingEvent parkingEvent);
}
