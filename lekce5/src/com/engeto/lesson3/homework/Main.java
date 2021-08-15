package com.engeto.lesson3.homework;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        Flower flower1 = null;
        try {
            flower1 = new Flower("Fuchsie");
            System.out.println(flower1.getWateringInfo());
            flower1.setLastWatering(LocalDate.now());
            System.out.println("Datum sazeni "+flower1.getPlanted());
        } catch (PlantException e) {
            e.printStackTrace();
        }


    }
}
