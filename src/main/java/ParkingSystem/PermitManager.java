/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ParkingSystem;

import ParkingSystem.Car;
import ParkingSystem.ParkingPermit;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mariatahir
 */
public class PermitManager {

    private List<ParkingPermit> parkingPermits;

    public PermitManager() {
        this.parkingPermits = new ArrayList<>();
    }

    public PermitManager(List<ParkingPermit> parkingpermits) {
        this.parkingPermits = parkingpermits;
    }

    public ParkingPermit getParkingPermit(String id) throws Exception {

        System.out.println("eGuyen input" + id);

        for (int i = 0; i < parkingPermits.size(); i++) {
            System.out.println("Nguyen compare " + parkingPermits.get(i).getId());
            if (parkingPermits.get(i).getId().equals(id)) {
                return parkingPermits.get(i);
            }
        }
        System.out.println("Nguyen id not exist");
        return null;
    }

    public int getNumberOfParkingPermitIssued() {
        return parkingPermits.size();
    }

    public ParkingPermit register(Car car) {
        ParkingPermit parkingPermit = new ParkingPermit(car.getLicensePlate(), car);
        parkingPermits.add(parkingPermit);
        return parkingPermit;
    }

}