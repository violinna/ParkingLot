/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkinglot;

import java.util.ArrayList;
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
    
    private class Car {
        String regNo;
        String color;
        public Car(String regNo, String color) {
            this.regNo = regNo;
            this.color = color;
        }
    }
    
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
    
}
