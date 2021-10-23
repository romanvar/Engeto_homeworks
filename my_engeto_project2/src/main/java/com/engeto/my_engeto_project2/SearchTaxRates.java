package com.engeto.my_engeto_project2;

import java.io.IOException;
import java.util.List;

public class SearchTaxRates{
//    int static lowThresholdu;
//    int highThreshold;

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



    }

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
    }}
