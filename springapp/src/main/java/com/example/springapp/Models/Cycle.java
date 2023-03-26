package com.example.springapp.Models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cycle {
    @Id
    int cycleId;
    String cycleName;
    int price;
    int size;
    String type;

 
    public int getCycleId() {
        return cycleId;
    }


    public void setCycleId(int cycleId) {
        this.cycleId = cycleId;
    }


    public String getCycleName() {
        return cycleName;
    }


    public void setCycleName(String cycleName) {
        this.cycleName = cycleName;
    }


    public int getPrice() {
        return price;
    }


    public void setPrice(int price) {
        this.price = price;
    }


    public int getSize() {
        return size;
    }


    public void setSize(int size) {
        this.size = size;
    }


    public String getType() {
        return type;
    }


    public void setType(String type) {
        this.type = type;
    }


    public Cycle(int cycleId, String cycleName, int price, int size, String type) {
        this.cycleId = cycleId;
        this.cycleName = cycleName;
        this.price = price;
        this.size = size;
        this.type = type;
    }


    public Cycle() {
    }

   

    
    
}
