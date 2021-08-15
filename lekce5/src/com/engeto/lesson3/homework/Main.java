package com.engeto.lesson3.homework;

public class Main {

    public static void main(String[] args) {
        Flower flower1 = null;
        try {
            flower1 = new Flower("Fuchsie");
        } catch (PlantException e) {
            e.printStackTrace();
        }

        if (flower1 != null) {
            System.out.println(flower1.getWateringInfo());
        }
    }
}
