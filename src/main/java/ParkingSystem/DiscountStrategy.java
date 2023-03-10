/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ParkingSystem;

import java.time.LocalDateTime;

/**
 *
 * @author mariatahir
 */
public interface DiscountStrategy {

    String getStrategyName();

    Double getDiscount(CarType carType, LocalDateTime dayOfTheWeek);

    void setDiscount(Double percentage);

    Money getParkingCharge(ParkingLot parkingLot, CarType carType, LocalDateTime date);
}
