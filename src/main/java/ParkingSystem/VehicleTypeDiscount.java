/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ParkingSystem;

import ParkingSystem.CarType;
import ParkingSystem.ParkingEvent;
import java.io.Serializable;


/**
 *
 * @author mariatahir
 */
public class VehicleTypeDiscount extends ParkingChargeDecorator{
    
    private Double discountRate = 0.1;

    public VehicleTypeDiscount(ParkingChargeCalculator calc) {
        super(calc);
    }

    @Override
     public Double getDiscount(ParkingEvent parkingEvent){
         if (isCompactCar(parkingEvent.getPermit().getCar().getType())){
             System.out.println("Compact car discount rate applied");
             return super.getDiscount(parkingEvent) + discountRate;
         }
         System.out.println("Vehicle type discount cannot be applied to this vehicle");
        return super.getDiscount(parkingEvent);
     }

    private boolean isCompactCar(CarType carType){
        return carType == CarType.COMPACT;
    }
    
}

