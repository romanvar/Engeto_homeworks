package com.engeto.my_project;

public class Main {
    public static final String FILENAME = "vat-eu.csv";
    private static int limit;


    public static void main(String[] args) {

        VATSummary vatSummary = new VATSummary();
        try{
            vatSummary = VATSummary.importFomCsvFile(FILENAME);
        } catch (VATException e) {
            System.err.println("Nepodařilo se načíst data ze souboru "+FILENAME+": "+e.getMessage());
        }

       vatSummary.printVats();
        vatSummary.printVatsOver20();
        try {
            System.out.println(" Please input value: ");
          limit = VATSummary.readIntKeyboardEnter();


        } catch (VATException e) {
            System.err.println("Integer was not loaded properly" + e.getLocalizedMessage());
        }


        try {
            vatSummary.printVatsOverLimitSortedDesc(limit);
        } catch (VATException e) {
            System.err.println("Nepodařilo se vygenerovat data do souboru "+FILENAME+": "+e.getMessage());
        }


    }
}
