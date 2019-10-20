package com.horseboarding.horseboarding.models;

public enum HorseType {

    PASTURE ("Pasture"),
    STALL ("Stall"),
    BOTH ("Stall and pasture");

    private final String name;

    HorseType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
