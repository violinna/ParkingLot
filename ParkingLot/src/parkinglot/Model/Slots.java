/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkinglot.Model;

import java.util.ArrayList;

/**
 *
 * @author hp
 */
public class Slots {
    int Capacity = 0;
    ArrayList<Integer> slotList;

    public Slots() {
    }

    
    public Slots(ArrayList<Integer> slotList) {
        this.slotList = slotList;
    }

    public int getCapacity() {
        return Capacity;
    }

    public void setCapacity(int Capacity) {
        this.Capacity = Capacity;
    }


    public ArrayList<Integer> getSlotList() {
        return slotList;
    }

    public void setSlotList(ArrayList<Integer> slotList) {
        this.slotList = slotList;
    }

    
    
}
