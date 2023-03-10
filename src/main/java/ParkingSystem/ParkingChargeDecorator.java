/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ParkingSystem;

import parkingsystem.ParkingEvent;

import java.io.Serializable;

/**
 *
 * @author mariatahir
 */
public abstract class ParkingChargeDecorator implements ParkingChargeCalculator, Serializable {

    private final ParkingChargeCalculator calc;

    public ParkingChargeDecorator(ParkingChargeCalculator calc) {
        this.calc = calc;

    }

    @Override
    public Double getDiscount(ParkingEvent parkingEvent) {

        return calc.getDiscount(parkingEvent);

    }