package com.engeto.my_project;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VATSummary {
    public static final String DELIMITER = "\t";  // tabulátor.. "\t"
    private List<VAT> list = new ArrayList<>();

    public static VATSummary importFomCsvFile(String filename) throws VATException {
        VATSummary vatSummary = new VATSummary();
        try (Scanner scanner = new Scanner(new FileInputStream(filename))) {
            while (scanner.hasNextLine()){
                String inputLine = scanner.nextLine();
                String[] items = inputLine.split(DELIMITER);
                if (items.length != 5) throw new VATException("Nesprávný počet položek na řádku: "+inputLine+" ("+items.length+" položek)");

                BigDecimal fullVAT_dot = BigDecimal.valueOf(Double.valueOf(items[2].replace(',','.')));
                BigDecimal reducedVAT_dot = BigDecimal.valueOf(Double.valueOf(items[3].replace(',','.')));
                Boolean specialVAT = Boolean.parseBoolean(items[4]);
                VAT vat = new VAT(items[0],items[1],fullVAT_dot,reducedVAT_dot, specialVAT);
                vatSummary.add(vat);

            }

        } catch (FileNotFoundException e) {
            throw new VATException("Soubor " + filename + " nenalezen " + e.getLocalizedMessage());
        }

        return null;
    }

    private void add(VAT e) {
        list.add(e);

    }
    public void printVats(){

        for (VAT vat : this.list) {
            System.out.println(vat.getStateName()+"("+vat.getStateShortcut()+")");

        }


    }

}
