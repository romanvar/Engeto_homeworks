package com.engeto.my_engeto_project2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SearchTaxRates{
    private static  String filename = "Standard rate under-XX.txt";
    public static final String DELIMITER = "\t";  // tabulátor.. "\t"

    public static void searchLowerThan(List<CountryVat> list) throws IOException {
        System.out.println(" \nSearching of Coutries with lower standard tax rate than: (input from keyboard) ");
        int lowThreshold = readIntKeyboardEnter();
        Double limit = Double.valueOf(lowThreshold);
        for(CountryVat countryVat : list){
        if(countryVat.getStandard_rate().compareTo(Double.valueOf(lowThreshold)) < 0){

            int index = list.indexOf(countryVat);
            TestMain.printItem(index, list);





        }
        }
        System.out.println(" Do you want to save search result into the file? Please input y/n");
        Scanner sc= new Scanner(System.in);
        String str= sc.nextLine();
//        System.out.print("You have entered: "+str);
        if (str.equalsIgnoreCase("y")){
        filename = filename.replace("XX",String.valueOf(lowThreshold));
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(filename))) {
            for (CountryVat countryVat : list) {
                if(countryVat.getStandard_rate().compareTo(Double.valueOf(lowThreshold)) < 0){
                    String toBeDisplayed = countryVat.getCountry()+DELIMITER +countryVat.getStandard_rate();

                    System.out.println(toBeDisplayed);
                    writer.println(toBeDisplayed);}}



    }}}

    private static int readIntKeyboardEnter() throws IOException {
        byte[] pole = new byte[10];
        String loaded;
        int i;
        try {
            System.out.println("Please input the value: ");
            System.in.read(pole);
            loaded = new String(pole).trim();
            i = Integer.valueOf(loaded);
            return i;
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException was thrown, that's why default value 20 was used");
            return 20;
        } catch (IOException e) {
            throw new IOException("Integer was not loaded properly" + e.getLocalizedMessage());
        }
    }

    public static void searchByCountryCode(Map<String, CountryVat> rates) {
        System.out.println(" Please input CountryCode to search details (example 'AT') ");
        Scanner sc= new Scanner(System.in);
        String str= sc.nextLine();
        CountryVat c = rates.get(str);
        System.out.println("Country = "+c.getCountry()+" Standard rate = "+c.getStandard_rate());

    }
}
