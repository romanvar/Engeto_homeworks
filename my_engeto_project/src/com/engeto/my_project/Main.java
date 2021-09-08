package com.engeto.my_project;

public class Main {
    public static final String FILENAME = "vat-eu.csv";

    public static void main(String[] args) {

        VATSummary vatSummary = new VATSummary();
        try{
            vatSummary = VATSummary.importFomCsvFile(FILENAME);
        } catch (VATException e) {
            System.err.println("Nepodařilo se načíst data ze souboru "+FILENAME+": "+e.getMessage());
        }
        //VATSummary.
       vatSummary.printVats();


    }
}
