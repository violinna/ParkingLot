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
    // Map regNo, slot
    Map<String, String> Map2;
    // Map color, List of RegNo
    Map<String, ArrayList<String>> Map3;
    
    public void createParkingLot(String count) {
        try {
            this.MAX_SIZE = Integer.parseInt(count);
        } catch (Exception e) {
            System.out.println("Invalid lot count");
            System.out.println();
        }
        this.slotList = new ArrayList<Integer>() {};
        
        for (int i=1; i<= this.MAX_SIZE; i++) {
            slotList.add(i);
        }
        
        this.Map1 = new HashMap<String, Car>();
        this.Map2 = new HashMap<String, String>();
        this.Map3 = new HashMap<String, ArrayList<String>>();
        System.out.println("Created parking lot with " + count + " slots");
        System.out.println();
    }
    
    public void tiket(String regNo, String color) {
        if (this.MAX_SIZE == 0) {
            System.out.println("Sorry, parking lot is not created");
            System.out.println();
        } else if (this.Map1.size() == this.MAX_SIZE) {
            System.out.println("Sorry, parking lot is full");
            System.out.println();
        } else {
            Collections.sort(slotList);
            String slot = slotList.get(0).toString();
            Car car = new Car(regNo, color);
            this.Map1.put(slot, car);
            this.Map2.put(regNo, slot);
            if (this.Map3.containsKey(color)) {
                ArrayList<String> regNoList = this.Map3.get(color);
                this.Map3.remove(color);
                regNoList.add(regNo);
                this.Map3.put(color, regNoList);
            } else {
                ArrayList<String> regNoList = new ArrayList<String>();
                regNoList.add(regNo);
                this.Map3.put(color, regNoList);
            }
            System.out.println("Allocated slot number: " + slot);
            System.out.println();
            slotList.remove(0);
        }
    }
    
    public void CarLeave(String slotNumber) {
        if (this.MAX_SIZE == 0) {
            System.out.println("Sorry, parking lot is not created");
            System.out.println();
        } else if (this.Map1.size() > 0) {
            Car carLeave = this.Map1.get(slotNumber);
            if (carLeave != null) {
                this.Map1.remove(slotNumber);
                this.Map1.remove(carLeave.regNumber);
                
                ArrayList<String> regNumberList = this.Map3.get(carLeave.color);
                
                if (regNumberList.contains(carLeave.regNumber)) {
                    regNumberList.remove(carLeave.regNumber);
                }
               
                this.slotList.add(Integer.parseInt(slotNumber));
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
}
