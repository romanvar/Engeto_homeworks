package com.engeto.lesson2.homework;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Main {

    public static void main( String[] args ) {
        Client client1 = new Client("Adela" , "Malikova" , LocalDate.of(1993 , 3 , 13));
        Client client2 = new Client("Jan" , "Dvoracek" , LocalDate.of(1995 , 5 , 5));
        client1.getDescription();
        client2.getDescription();

        Room room1 = new Room(1 , true , true , BigDecimal.valueOf(1000));
        Room room2 = new Room(1 , true , true , BigDecimal.valueOf(1000));
        Room room3 = new Room(3 , true , false , BigDecimal.valueOf(2400));
        room1.getDescription();

		Reservation reservation1 = new Reservation(LocalDate.of(2021 , 7 , 19) , LocalDate.of(2021 , 7 , 26) ,
				room1 , "pracovni" , client1);
		reservation1.getDescription();
        Reservation reservation2 = new Reservation(LocalDate.of(2021 , 1 , 9) , LocalDate.of(2021 , 9 , 14) ,
                room3 , "rekreacni" , client1);
        reservation2.addClient(client2);
        reservation2.getDescription();


    }


}
