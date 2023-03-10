/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ParkingSystem;

import ParkingSystem.ParkingEvent;
import java.time.DayOfWeek;
import java.time.LocalDateTime;

/**
 *
 * @author mariatahir
 */
public class WeekdayDiscount extends ParkingChargeDecorator {

    private Double discountRate = 0.1;

    public WeekdayDiscount(ParkingChargeCalculator calc) {
        super(calc);
    }

    @Override
    public Double getDiscount(ParkingEvent parkingEvent) {
        if (parkingEvent.getTimeOut() != null) {
            if (isWeekday(parkingEvent.getTimeOut().getDayOfWeek())) {
                System.out.println("Weekday discount rate applied");
                return super.getDiscount(parkingEvent) + discountRate;
            }
        } else {
            if (isWeekday(parkingEvent.getTimeIn().getDayOfWeek())) {
                System.out.println("Weekday discount rate applied");
                return super.getDiscount(parkingEvent) + discountRate;
            }
        }
        System.out.println("Discount cannot be applied on weekend");
        return super.getDiscount(parkingEvent);
    }

    private boolean isWeekday(DayOfWeek day) {
        var dayOfWeek = day.getValue();
        if (1 <= dayOfWeek && dayOfWeek <= 5) {
            return true;
        }
        return false;
    }

}