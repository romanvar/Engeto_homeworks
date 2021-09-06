package com.engeto.lesson5;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Flowers {
    public static final String DELIMITER = "\t";
    private List<Flower> listFlowers = new ArrayList<>();

    public static Flowers importFromTextFile(String filename) throws PlantException {
        Flowers flowers = new Flowers();
        try (Scanner scanner = new Scanner(new FileInputStream(filename))) {
            while (scanner.hasNextLine()) {
                String inputline = scanner.nextLine();
                // System.out.println("Byla nactena jedna radka "+inputline);
                String[] items = inputline.split(DELIMITER);
                if (items.length != 5)
                    throw new PlantException("Nespravny pocet polozek na radku: " + inputline + " (" + items.length + " položek)"
                    );
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate parsedDatePlanted = LocalDate.parse(items[4], formatter);
                LocalDate parsedDateLastWatering = LocalDate.parse(items[3], formatter);
                int i = Integer.parseInt(items[2]);
                System.out.println(" datum zalivky je: " + items[4]);

                //Flower flower = new Flower(items[0], items[1], parsedDatePlanted, parsedDateLastWatering, i);
                flowers.addFlower(new Flower(items[0], items[1], parsedDatePlanted, parsedDateLastWatering, i));

            }

        } catch (FileNotFoundException ex) {
            throw new PlantException("Soubor " + filename + " nenalezen " + ex.getLocalizedMessage());
        } catch (Exception ex) {
            throw new PlantException("Some Exception: " + ex.getLocalizedMessage());
        }


        return flowers;
    }

    public void exportToFile(String filename) throws PlantException {
        
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(filename))) {
            for (Flower flower : listFlowers) {
                writer.println(
                        flower.getName() + DELIMITER
                                + flower.getNotes() + DELIMITER
                                + flower.getFrequencyOfWatering() + DELIMITER
                                + flower.getLastWatering() + DELIMITER
                                + flower.getPlanted() + DELIMITER

                );
            }
        } catch (FileNotFoundException e) {
            throw new PlantException("Soubor " + filename + " nenalezen: " + e.getLocalizedMessage());
        }
    }


    public void addFlower(Flower newFlower) {
        listFlowers.add(newFlower);
    }

    public void removeFlower(Flower newFlower) {
        listFlowers.remove(newFlower);
    }

}
