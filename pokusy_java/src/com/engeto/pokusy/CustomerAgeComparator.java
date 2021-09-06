package com.engeto.pokusy;

import java.util.Comparator;

public class CustomerAgeComparator implements Comparator<Customer> {
    @Override
    public int compare(Customer first, Customer second) {
        return first.getBirthDate().compareTo(second.getBirthDate());
    }
}
