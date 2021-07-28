package com.engeto.ifloop;

import java.util.ArrayList;
import java.util.List;

public class Main {

    //region Demo

    /**
     * Example of use of {@link //Support#safeReadInt()}
     * <p>
     * Read one integer from input and print it to output
     *
     * @return integer from input
     */
    public static void readOneIntFromInputAndPrintIt() {
        int input = Support.safeReadInt();
        System.out.println("You entered: " + input);
    }
    //endregion

    //region Loops

    /**
     * Read integers from input and print them until negative
     * input.
     */
    public static void readIntsFromInputAndPrintItUntilNegative() {

        int input = Support.safeReadInt();
        while (input >= 0) {
            System.out.println("NonNegative Input is: " + input);
            input = Support.safeReadInt();
        }
        System.out.println("You have entered negative input");
    }

    /**
     * Sum all input numbers (negative number terminates reading) and return result.
     *
     * @return Sum of input numbers expect of terminating negative number.
     */
    public static int sumAllInputUntilNegative() {
        int count = 0;
        int input = Support.safeReadInt();
        while (input >= 0) {
            System.out.println("NonNegative Input is: " + input);
            count += input;
            input = Support.safeReadInt();
        }
        System.out.println("You have entered negative input");

        return count;
    }

    /**
     * Store all input numbers in a list (negative number terminates reading).
     *
     * @return List of read values (terminating negative value is NOT included)
     */
    public static List storeAllInputInArrayListUntilNegative() {
        List<Integer> list = new ArrayList<>();
        int input = Support.safeReadInt();
        while (input >= 0) {
            System.out.println("NonNegative Input is: " + input);
            list.add(input);
            input = Support.safeReadInt();
        }
        System.out.println("You have entered negative input");

        return list;
    }

    /**
     * Print all integers from given list.
     *
     * @param list List of integers to print.
     */
    public static void printAllIntegersFromList( List<Integer> list ) {
        System.out.println(list);
    }

    public static Integer sumAllIntegersFromList( List<Integer> list ) {
        int count = list.stream().mapToInt(i -> i).sum();
        return count;
    }
    //endregion

    //region Conditions

    /**
     * Print integers from given list that are smaller than given limit.
     *
     * @param limit Limit - only smaller integers are printed
     * @param list  List of integers to print.
     */
    public static void printIntegersUnderLimit( List<Integer> list , int limit ) {
        System.out.println("Limit is: " + limit);
        list.stream().forEach(i -> {
            if (i < limit) System.out.println("Number smaller than limit " + i);
        });
    }

    /**
     * Print integers from given list. Replace 1 by "one", 2 by "two", 3 by "tři" - print others with no change.
     *
     * @param list List of integers to print.
     */
    public static void printIntegersWithReplace( List<Integer> list ) {

        list.stream().forEach(i -> {
            switch (i) {
                case 1:
                    System.out.println("one");
                    break;
                case 2:
                    System.out.println("two");
                    break;
                case 3:
                    System.out.println("three");
                    break;
                default:
                    System.out.println(i);

            }

        });
    }
    //endregion

    public static void main( String[] args ) {
        // Example
        System.out.println("--- Example - read and print one integer ---");
        readOneIntFromInputAndPrintIt();
        // ---
        System.out.println("--- Task 1 - read and print integers until negative ---");
        readIntsFromInputAndPrintItUntilNegative();
        // ---
        System.out.println("--- Task 2 - sum all integers until negative ---");
        System.out.println("Total sum: " + sumAllInputUntilNegative());

        // ---
        System.out.println("--- Task 3 - read integers to list until negative ---");
        List<Integer> list = storeAllInputInArrayListUntilNegative();
        System.out.println(list);
        // ---
        System.out.println("--- Task 4 - print all integers from list ---");
        printAllIntegersFromList(list);
        // ---
        System.out.println("--- Task 5 - sum all integers in list ---");
        System.out.println("Total sum: " + sumAllIntegersFromList(list));
        // ---
        System.out.println("--- Task 6 - print integers under 5 from list ---");
        printIntegersUnderLimit(list , 5);
        // ---
        System.out.println("--- Task 7 - print integers - replace: 1 => \"one\", 2 => \"two\", 3 => \"three\" ---");
        printIntegersWithReplace(list);
    }
}
