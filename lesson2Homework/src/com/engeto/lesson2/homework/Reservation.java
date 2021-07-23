package com.engeto.lesson2.homework;

import java.time.LocalDate;

public class Reservation {
    private LocalDate checkIn;
    private LocalDate checkOut;
    private Room room;
    private Client client1, client2, client3;
    private String visit;
    private final String working = "pracovni";
    private final String recreant = "rekreacni";

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public void setCheckIn( LocalDate checkIn ) {
        this.checkIn = checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public void setCheckOut( LocalDate checkOut ) {
        this.checkOut = checkOut;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom( Room room ) {
        this.room = room;
    }

    public Client getClient1() {
        return client1;
    }

    public void setClient1( Client client1 ) {
        this.client1 = client1;
    }

    public Client getClient2() {
        return client2;
    }

    public void setClient2( Client client2 ) {
        this.client2 = client2;
    }

    public Client getClient3() {
        return client3;
    }

    public void setClient3( Client client3 ) {
        this.client3 = client3;
    }

    public Reservation() {
        this.checkIn = null;
        this.checkOut = null;
        // room.occupied(this.checkIn, this.checkOut);


    }

    public Reservation( LocalDate checkIn , LocalDate checkOut , Room room , String visita , Client client1 ) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.room = room;

        if (visita.equals(working)) {
            this.visit = working;
        } else {
            this.visit = recreant;
        }
        this.client1 = client1;
        this.client2 = null;
        this.client3 = null;

    }

    public Reservation( LocalDate checkIn , LocalDate checkOut , Room room , String visit , Client client1 , Client client2 ) {
        this(checkIn , checkOut , room , visit , client1);

        this.client2 = client2;
        this.client3 = null;

    }

    public Reservation( LocalDate checkIn , LocalDate checkOut , Room room , String visit , Client client1 , Client client2 , Client client3 ) {
        this(checkIn , checkOut , room , visit , client1 , client2);
        this.client3 = client3;

    }


    public void addClient( Client client ) {
        if (this.client2 == null) {
            this.client2 = client;
        } else if (this.client3 == null) {
            this.client3 = client;
        } else {
            System.out.println("Impossible to add client, the room is full.");

        }
    }

    public void getDescription() {
        System.out.println("\nDescription of Reservation\n");
        System.out.println("CheckIn " + this.checkIn.toString() + " CheckOut" + this.checkOut.toString() + " Room " + this.room.getRoomNumber());


        if (this.client1 != null) {
            this.client1.getDescription();
        } else {
            System.out.println("Sorry, client1 doesn't exist. :-( ");
        }

        if (this.client2 != null) {
            this.client2.getDescription();
        } else {
            System.out.println("Sorry, client2 doesn't exist. :-( ");
        }
        if (this.client3 != null) {
            this.client3.getDescription();
        } else {
            System.out.println("Sorry, client3 doesn't exist. :-( ");
        }
    }
}
