package com.engeto.pokusy;

import java.time.LocalDate;

public class Customer implements Comparable<Customer> {
    private int id;
    private String name;
    private LocalDate birthDate;

    public Customer(int id, String name, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }
    @Override
    public int compareTo(Customer second) {
        return this.name.compareTo(second.name);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
