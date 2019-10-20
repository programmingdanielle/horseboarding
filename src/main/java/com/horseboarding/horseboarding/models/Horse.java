package com.horseboarding.horseboarding.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Horse {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min = 5, max = 40)
    private String name;

    @NotNull
    @Size(min = 5, max = 500)
    private String description;

    private HorseType type;

    @NotNull
    private int cost;

    @NotNull
    private String location;

    public Horse() {};

    public Horse(String name, String description, int cost, String location) {
        this();
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public HorseType getType() {
        return type;
    }

    public void setType(HorseType type) {
        this.type = type;
    }
}
