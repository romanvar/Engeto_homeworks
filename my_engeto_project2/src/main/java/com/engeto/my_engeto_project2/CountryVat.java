package com.engeto.my_engeto_project2;

public class CountryVat {
    String country;
    Object standard_rate;
    Object reduced_rate;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Object getStandard_rate() {
        return standard_rate;
    }

    public void setStandard_rate(Object standard_rate) {
        this.standard_rate = standard_rate;
    }

    public Object getReduced_rate() {
        return reduced_rate;
    }

    public void setReduced_rate(Object reduced_rate) {
        this.reduced_rate = reduced_rate;
    }
}
