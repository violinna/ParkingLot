/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkinglot.Interface;

/**
 *
 * @author hp
 */
public interface ParkingInterface {
    void getAllRegNumByColor(String color);
    void getSlotNumByRegNum(String regNum);
    void getSlotNumByColor(String color);
}
