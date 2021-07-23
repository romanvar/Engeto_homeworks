package com.engeto.lesson2.homework;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Room {
    private static int counter = 1;
    private int roomNumber;
    private int numberBeds;
    private boolean seaView;
    private boolean balcony;
    private boolean occupied;

    {
        occupied = false;
    }

    BigDecimal roomPrice;

    public Room( int numberBeds , boolean seaView , boolean balcony , BigDecimal roomPrice ) {
        this.numberBeds = numberBeds;
        this.seaView = seaView;
        this.balcony = balcony;
        this.roomPrice = roomPrice;
        this.occupied = false;
        this.roomNumber = counter;
        counter++;

    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public int getNumberBeds() {
        return numberBeds;
    }

    public boolean isSeaView() {
        return seaView;
    }

    public boolean isBalcony() {
        return balcony;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public BigDecimal getRoomPrice() {
        return roomPrice;
    }

    public void getDescription() {
        System.out.println("Room Number: " + this.roomNumber + " Number of beds: " + this.numberBeds + " Seaview: " + this.seaView + " Balcony " + this.balcony + " Price: " + this.roomPrice);
    }


}
