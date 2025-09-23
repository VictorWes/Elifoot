package com.java10x.elifoot.enums;

public enum Position {

    GOALKEEPER("Goalkeeper"),
    DEFENDER("Defender"),
    MIDFIELDER("Midfielder"),
    FORWARD("Forward"),
    FULLBACK("Fullback");

    private final String label;


    Position(String label) {
        this.label = label;
    }

    public String getLabel(){
        return label;
    }
}
