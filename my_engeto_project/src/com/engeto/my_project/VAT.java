package com.engeto.my_project;

import java.math.BigDecimal;

public class VAT {
    private String stateShortcut;
    private String stateName;
    private BigDecimal fullVAT;
    private BigDecimal reducedVAT;
    private boolean specialVAT;


    public VAT(String stateShortcut, String stateName, BigDecimal fullVAT, BigDecimal reducedVAT, boolean specialVAT) {
        this.stateShortcut = stateShortcut;
        this.stateName = stateName;
        this.fullVAT = fullVAT;
        this.reducedVAT = reducedVAT;
        this.specialVAT = specialVAT;
    }
}
