/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkinglot.Controller;

import parkinglot.Interface.ParkingInterface;
import parkinglot.Model.Car;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import parkinglot.Model.Slots;

/**
 *
 * @author violin
 */
public class ParkingController implements ParkingInterface{
    Slots slot = new Slots();
    Car car = new Car();
    
    int CAPACITY = slot.getCapacity();
    
    ArrayList<Integer> slotList = slot.getSlotList();
    // Map slot, car
    Map<String, Car> Map1;
    // regNumber, slot
    Map<String, String> Map2;
    // Map for color, List for Registrasi
    Map<String, ArrayList<String>> Map3;
    
    public void createParkingLot(String count) {
        try {
            CAPACITY = Integer.parseInt(count);
        } catch (Exception e) {
            System.out.println("Invalid lot count");
            System.out.println();
        }
        slotList = new ArrayList<Integer>() {};
        
        for (int i=1; i<= CAPACITY; i++) {
            slotList.add(i);
        }
        
        Map1 = new HashMap<String, Car>();
        Map2 = new HashMap<String, String>();
        Map3 = new HashMap<String, ArrayList<String>>();
        System.out.println("Created parking lot with " + count + " slots");
        System.out.println();
    }
    
    public void tiket(String regNumber, String color) {
        if (CAPACITY == 0) {
            System.out.println("Sorry, parking lot is not created");
            System.out.println();
        } else if (Map1.size() == CAPACITY) {
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
    
    public void carLeave(String slotNumber) {
        if (CAPACITY == 0) {
            System.out.println("Sorry, parking lot is not created");
            System.out.println();
        } else if (Map1.size() > 0) {
            car = Map1.get(slotNumber);
            if (car != null) {
                Map1.remove(slotNumber);
                Map1.remove(car.getRegNumber());
                
                ArrayList<String> regNumberList = Map3.get(car.getColor());
                
                if (regNumberList.contains(car.getRegNumber())) {
                    regNumberList.remove(car.getRegNumber());
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
        if (CAPACITY == 0) {
            System.out.println("Sorry, parking lot is not created");
            System.out.println();
        } else if (Map1.size() > 0) {
            System.out.println("Slot No.\t Registration No.\t Color");
            for (int i = 1; i <= CAPACITY; i++) {
                String indexCar = Integer.toString(i);
                
                if (Map1.containsKey(indexCar)) {
                    car = Map1.get(indexCar);
                    System.out.println(i + "\t" + car.getRegNumber() + "\t" + car.getColor());
                }
            }
            System.out.println();
        } else {
            System.out.println("Parking lot is empty");
            System.out.println();
        }
    }

    @Override
    public void getAllRegNumByColor(String color) {
        if (CAPACITY == 0) {
            System.out.println("Sorry, parking lot is not created");
            System.out.println();
        } else if (Map3.containsKey(color)) {
            ArrayList<String> regNumList = Map3.get(color);
            System.out.println();
            
            for (int i=0; i < regNumList.size(); i++) {
                if (!(i==regNumList.size() - 1)){
                    System.out.print(regNumList.get(i) + ",");
                } else {
                    System.out.print(regNumList.get(i));
                }
            }
        } else {
            System.out.println("Not found");
            System.out.println();
        }
    }
    
    public void getSlotNumByColor(String color) {
        if (CAPACITY == 0) {
            System.out.println("Sorry, parking lot is not created");
            System.out.println();
        } else if (Map3.containsKey(color)) {
            ArrayList<String> regNoList = Map3.get(color);
            System.out.println();
            
            for (int i=0; i < regNoList.size(); i++) {
                slotList.add(Integer.valueOf(Map2.get(regNoList.get(i))));
            }
            
            Collections.sort(slotList);
            
            for (int j=0; j < slotList.size(); j++) {
                if (!(j == slotList.size() - 1)) {
                    System.out.print(slotList.get(j) + ",");
                } else {
                    System.out.print(slotList.get(j));
                }
            }
            
            System.out.println();
        } else {
            System.out.println("Not found");
            System.out.println();
        }
    }
    
    public void getSlotNumByRegNum(String regNum) {
        if (CAPACITY == 0) {
            System.out.println("Sorry, parking lot is not created");
            System.out.println();
        } else if (Map2.containsKey(regNum)) {
            System.out.println(Map2.get(regNum));
        } else {
            System.out.println("Not found");
            System.out.println();
        }
    }

}
