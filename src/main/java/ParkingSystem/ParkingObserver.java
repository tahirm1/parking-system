/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ParkingSystem;

import ParkingSystem.ParkingEvent;

/**
 *
 * @author mariatahir
 */
//TO DO -  THIS FUNCTION IS DECLARED BUT PERFORMS NO ACTIONS
public interface ParkingObserver {
    public void onParkingEventReceived(ParkingEvent event);
    public ParkingTransaction park(ParkingEvent event);
}
