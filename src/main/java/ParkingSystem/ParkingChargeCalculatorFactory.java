/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ParkingSystem;

import parkingsystem.VehicleTypeDiscount;
import parkingsystem.WeekdayDiscount;
import java.io.Serializable;


/**
 *
 * @author mariatahir
 */
public class ParkingChargeCalculatorFactory implements Serializable {

    public ParkingChargeCalculator getParkingChargeCalculator(String strategy) {
        
        if ("WeekdayDiscount".equalsIgnoreCase(strategy)) {

            System.out.println("WeekdayDiscountCaculator created");
            return new WeekdayDiscount(new BasePakingChargeCalculator());

        } else if ("CarTypeDiscount".equalsIgnoreCase(strategy)) {

            System.out.println("CarTypeDiscount created");
            return new VehicleTypeDiscount(new BasePakingChargeCalculator());

        } else if ("WeekdayCarTypeDiscount".equalsIgnoreCase(strategy)) {

            System.out.println("WeekdayDiscount and CarTypeDiscount created");
            return new WeekdayDiscount(new VehicleTypeDiscount(new BasePakingChargeCalculator()));
        } else if (strategy == null) {
            System.out.println("Base calculator created");
            return new BasePakingChargeCalculator();
        }
        return null;
    }
}

