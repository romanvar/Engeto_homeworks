package com.engeto.pokusy;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        System.out.println("ahoj");

        ArrayList<Customer> customers = new ArrayList<>();
        customers.add(new Customer(1, "Karel_senior", LocalDate.of(1979, 1,1)));
        customers.add(new Customer(1, "Karel", LocalDate.of(2009, 1,1)));
        customers.add(new Customer(2, "Zora", LocalDate.of(1999, 1,1)));
        customers.add(new Customer(3, "Adam", LocalDate.of(1949, 1,1)));
        Collections.sort(customers, new CustomerAgeComparator());
        customers.forEach( n -> { System.out.println(n.getName()); } );

        Integer [] pole = new Integer[11];
        Integer[] pole1 = {1,2,3,4};
        System.out.println(pole.length);
        System.out.println(pole1.length);
        for(Customer c : customers){
            System.out.println("jmeno "+c.getName());
        }

    }
}
