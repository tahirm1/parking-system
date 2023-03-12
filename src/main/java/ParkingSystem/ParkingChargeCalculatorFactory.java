/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ParkingSystem;

import ParkingSystem.VehicleTypeDiscount;
import ParkingSystem.WeekdayDiscount;
import java.io.Serializable;


/**
 *
 * @author mariatahir
 */
public class ParkingChargeCalculatorFactory implements Serializable {

  // variables
    BaseParkingChargeCalculator parkingCalculator = new BaseParkingChargeCalculator();

    public ParkingChargeCalculator getParkingChargeCalculator(String strategy) {
        if ("WeekdayDiscount".equalsIgnoreCase(strategy)) {

            System.out.println("WeekdayDiscountCaculator created");
            return new WeekdayDiscount(parkingCalculator);

        } else if ("CarTypeDiscount".equalsIgnoreCase(strategy)) {

            System.out.println("CarTypeDiscount created");
            return new VehicleTypeDiscount(parkingCalculator);

        } else if ("WeekdayCarTypeDiscount".equalsIgnoreCase(strategy)) {

            System.out.println("WeekdayDiscount and CarTypeDiscount created");
            return new WeekdayDiscount(new VehicleTypeDiscount(parkingCalculator));
        } else if (strategy == null) {
            System.out.println("Base calculator created");
            return parkingCalculator;
        }
        return null;
    }
}

