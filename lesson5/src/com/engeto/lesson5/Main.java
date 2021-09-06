package com.engeto.lesson5;

import java.io.FileInputStream;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static final String INPUTFILENAME = "kvetiny.txt";
    public static final String OUTPUTFILENAME = "vystup.txt";

    public static void main(String[] args) {
        String currentDir = System.getProperty("user.dir");
        System.out.println("Current dir using System:" + currentDir);

        Flower flower1 = null, flower2 = null, flower3 = null;
        try {
            flower1 = new Flower("Fuchsie");
            flower2 = new Flower("Tulipan");
            flower3 = new Flower("Pampeliska");
            System.out.println(flower1.getWateringInfo());
            flower1.setLastWatering(LocalDate.now());
            System.out.println("Datum sazeni " + flower1.getPlanted());
            //  Flowers.addFlower(flower1);
        } catch (PlantException e) {
            e.printStackTrace();
        }
        Flowers flowers = new Flowers();
        flowers.addFlower(flower1);
        try {
            flowers = Flowers.importFromTextFile(INPUTFILENAME);
            flowers.addFlower(flower1);
            flowers.addFlower(flower2);
            flowers.removeFlower(flower1);
            flowers.addFlower(flower3);

        } catch (PlantException e) {
            e.printStackTrace();
        }

        try {
            flowers.exportToFile(OUTPUTFILENAME);
        } catch (PlantException e) {
            e.printStackTrace();
        }


    }
}
