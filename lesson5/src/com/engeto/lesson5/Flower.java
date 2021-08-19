package com.engeto.lesson5;
import java.time.LocalDate;


public class Flower {
    private String name, notes;
    private LocalDate planted, lastWatering;
    private int frequencyOfWatering;

    public Flower( String name, String notes, LocalDate planted, LocalDate lastWatering, int frequencyOfWatering ) {
//        this(notes, planted, lastWatering, frequencyOfWatering);
        this.name = name;
        this.notes = notes;
        this.planted = planted;
        this.lastWatering = lastWatering;
        this.frequencyOfWatering = frequencyOfWatering;
    }

    public Flower( String notes ,  LocalDate lastWatering  ) throws PlantException {

        this(LocalDate.now(), 7);

        this.notes = "";
        this.lastWatering = lastWatering;
    }

    public Flower( LocalDate planted , int frequencyOfWatering ) throws PlantException {
        this.planted = planted;
        if(frequencyOfWatering < 1 ){
            throw new PlantException("Frekvence zalivky musi byt kladne cislo, toto je spatne: "+frequencyOfWatering);
        }
        this.frequencyOfWatering = frequencyOfWatering;

    }
    public Flower (String name) throws PlantException {

        this("", LocalDate.now());
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes( String notes ) {
        this.notes = notes;
    }

    public LocalDate getPlanted() {
        return planted;
    }

    public void setPlanted( LocalDate planted ) {
        this.planted = planted;
    }

    public LocalDate getLastWatering() {
        return lastWatering;
    }

    public void setLastWatering( LocalDate lastWatering ) throws PlantException {
//        if (lastWatering < this.getPlanted())
        if (lastWatering.isBefore(this.getPlanted())) {
            throw new PlantException("Datum zalivky "+lastWatering+" nemuze byt starsi nez datum sazeni " + this.getPlanted());
        }
        this.lastWatering = lastWatering;
    }

    public int getFrequencyOfWatering() {
        return frequencyOfWatering;
    }

    public void setFrequencyOfWatering( int frequencyOfWatering ) {
        this.frequencyOfWatering = frequencyOfWatering;
    }
    public String getWateringInfo(){
        LocalDate nextRecommendedWatering = this.lastWatering.plusDays(this.frequencyOfWatering);
        String pom = "Name: "+this.name+"\nlast watering: "+this.lastWatering.toString()
                +"\nRecommended date of next watering is: "+nextRecommendedWatering.toString();

        return pom;
    }
}