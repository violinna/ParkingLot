/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkinglot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author violin
 */
public class Parking {
    int MAX_SIZE = 0;
    
    ArrayList<Integer> slotList;
    // Map slot, car
    Map<String, Car> Map1;
    // Map regNumber, slot
    Map<String, String> Map2;
    // Map color, List of RegNumber
    Map<String, ArrayList<String>> Map3;
    
    public void createParkingLot(String count) {
        try {
            MAX_SIZE = Integer.parseInt(count);
        } catch (Exception e) {
            System.out.println("Invalid lot count");
            System.out.println();
        }
        slotList = new ArrayList<Integer>() {};
        
        for (int i=1; i<= MAX_SIZE; i++) {
            slotList.add(i);
        }
        
        Map1 = new HashMap<String, Car>();
        Map2 = new HashMap<String, String>();
        Map3 = new HashMap<String, ArrayList<String>>();
        System.out.println("Created parking lot with " + count + " slots");
        System.out.println();
    }
    
    public void tiket(String regNumber, String color) {
        if (MAX_SIZE == 0) {
            System.out.println("Sorry, parking lot is not created");
            System.out.println();
        } else if (Map1.size() == MAX_SIZE) {
            System.out.println("Sorry, parking lot is full");
            System.out.println();
        } else {
            Collections.sort(slotList);
            String slot = slotList.get(0).toString();
            Car car = new Car(regNumber, color);
            Map1.put(slot, car);
            Map2.put(regNumber, slot);
            if (Map3.containsKey(color)) {
                ArrayList<String> regNumList = Map3.get(color);
                Map3.remove(color);
                regNumList.add(regNumber);
                Map3.put(color, regNumList);
            } else {
                ArrayList<String> regNumList = new ArrayList<String>();
                regNumList.add(regNumber);
                Map3.put(color, regNumList);
            }
            System.out.println("Allocated slot number: " + slot);
            System.out.println();
            slotList.remove(0);
        }
    }
    
    public void CarLeave(String slotNumber) {
        if (MAX_SIZE == 0) {
            System.out.println("Sorry, parking lot is not created");
            System.out.println();
        } else if (Map1.size() > 0) {
            Car carLeave = Map1.get(slotNumber);
            if (carLeave != null) {
                Map1.remove(slotNumber);
                Map1.remove(carLeave.regNumber);
                
                ArrayList<String> regNumberList = Map3.get(carLeave.color);
                
                if (regNumberList.contains(carLeave.regNumber)) {
                    regNumberList.remove(carLeave.regNumber);
                }
               
                slotList.add(Integer.parseInt(slotNumber));
                System.out.println("Slot number " + slotNumber + " is free");
                System.out.println();
            } else {
                System.out.println("Slot number " + slotNumber 
                        + " is already empty");
                System.out.println();
            }
        } else {
            System.out.println("Parking lot is empty");
            System.out.println();
        }
    }
    
    public void parkingStatus() {
        if (MAX_SIZE == 0) {
            System.out.println("Sorry, parking lot is not created");
            System.out.println();
        } else if (Map1.size() > 0) {
            System.out.println("Slot No.\t Registration No.\t Color");
            Car car;
            for (int i = 1; i <= MAX_SIZE; i++) {
                String indexCar = Integer.toString(i);
                
                if (Map1.containsKey(indexCar)) {
                    car = Map1.get(indexCar);
                    System.out.println(i + "\t" + car.regNumber + "\t" + car.color);
                }
            }
            System.out.println();
        } else {
            System.out.println("Parking lot is empty");
            System.out.println();
        }
    }
    
}
