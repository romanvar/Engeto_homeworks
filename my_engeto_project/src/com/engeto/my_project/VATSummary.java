package com.engeto.my_project;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class VATSummary {
    public static final String DELIMITER = "\t";  // tabulátor.. "\t"
    private String listUnderLimit ="Sazba VAT 20 % nebo nižší nebo používají speciální sazbu:";
    private String filename = "vat-over-20.txt";
    private List<VAT> list = new ArrayList<>();

    public static VATSummary importFomCsvFile(String filename) throws VATException {
        VATSummary vatSummary = new VATSummary();
        try (Scanner scanner = new Scanner(new FileInputStream(filename))) {
            while (scanner.hasNextLine()){
                String inputLine = scanner.nextLine();
                String[] items = inputLine.split(DELIMITER);
                if (items.length != 5) throw new VATException("Nesprávný počet položek na řádku: "+inputLine+" ("+items.length+" položek)");
                char oldChar = ',';
                char newChar = '.';
                BigDecimal fullVAT_dot = BigDecimal.valueOf(Double.valueOf(items[2].replace(oldChar,newChar)));
                BigDecimal reducedVAT_dot = BigDecimal.valueOf(Double.valueOf(items[3].replace(oldChar,newChar)));
                boolean specialVAT_bol = Boolean.parseBoolean(items[4]);
                VAT vat = new VAT(items[0],items[1],fullVAT_dot,reducedVAT_dot, specialVAT_bol);

                vatSummary.add(vat);



            }

        } catch (FileNotFoundException e) {
            throw new VATException("Soubor " + filename + " nenalezen " + e.getLocalizedMessage());
        }

        return vatSummary;
    }

    public static int readIntKeyboardEnter() throws VATException {
        byte[] pole = new byte[10];
        String loaded;
        int i;
        try {
            System.in.read(pole);
            loaded = new String(pole).trim();
            i = Integer.valueOf(loaded).intValue();
            return i;
        }
        catch (NumberFormatException e){
            return 20;
        } catch (IOException e) {
            throw new VATException("Integer was not loaded properly" + e.getLocalizedMessage());
        }
    }

    private void add(VAT e) {
        list.add(e);

    }
    public void printVats(){

        for (VAT vat : this.list) {
            System.out.println(vat.getStateName()+" ("+vat.getStateShortcut()+") "+vat.getFullVAT()+" %");

        }


    }

    public void printVatsOver20() {

        System.out.println("List of VATs over 20% and without specialVAT");
        for (VAT vat : this.list) {
            if(vat.getFullVAT().compareTo(BigDecimal.valueOf(20)) > 0 && vat.isSpecialVAT() == false) {
                System.out.println(vat.getStateName()+" ("+vat.getStateShortcut()+") "+vat.getFullVAT()+" %");
            }
        }
    }


    public void printVatsOverLimitSortedDesc(int limit) throws VATException {
        System.out.println("Sorted Descending List of VATs over 20% and without specialVAT");
        Collections.sort(list, Collections.reverseOrder());
        filename = filename.replace("20",String.valueOf(limit));
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(filename))) {
        for (VAT vat : this.list) {
            if(vat.getFullVAT().compareTo(BigDecimal.valueOf(limit)) > 0 && vat.isSpecialVAT() == false) {
                String toBeDisplayed = vat.getStateName()+DELIMITER +"("+vat.getStateShortcut()+")"+DELIMITER +vat.getFullVAT()+" %";

                System.out.println(toBeDisplayed);
                writer.println(toBeDisplayed);
            }else {
                listUnderLimit = listUnderLimit+" "+vat.getStateShortcut()+",";
            }
        }
        System.out.println("==================");
        writer.println("==================");
        listUnderLimit = listUnderLimit.replace("20 %",(limit+" %"));
        System.out.println(listUnderLimit.substring(0, listUnderLimit.length() - 1));
        writer.println(listUnderLimit.substring(0, listUnderLimit.length() - 1));
    }
        catch(FileNotFoundException e ){ throw new VATException("Soubor "+filename+" nenalezen: "+e.getLocalizedMessage());
        }
    }




}
