package com.ccamacho.canilroomviewmodel.model;

import com.google.gson.annotations.SerializedName;

public class Dog {

    private int id;
    private String name;

    @SerializedName("country_code")
    private String countryCode;

    @SerializedName("bred_for")
    private String breadFor;

    @SerializedName("breed_group")
    private String breedGroup;

    @SerializedName("life_span")
    private String lifeSpan;

    private String temperament;
    private String origin;
    private Weight weight;
    private Height height;

    public Dog(int id, String name, String countryCode, String breadFor, String breedGroup, String lifeSpan, String temperament, String origin, Weight weight, Height height) {
        this.id = id;
        this.name = name;
        this.countryCode = countryCode;
        this.breadFor = breadFor;
        this.breedGroup = breedGroup;
        this.lifeSpan = lifeSpan;
        this.temperament = temperament;
        this.origin = origin;
        this.weight = weight;
        this.height = height;
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

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getBreadFor() {
        return breadFor;
    }

    public void setBreadFor(String breadFor) {
        this.breadFor = breadFor;
    }

    public String getBreedGroup() {
        return breedGroup;
    }

    public void setBreedGroup(String breedGroup) {
        this.breedGroup = breedGroup;
    }

    public String getLifeSpan() {
        return lifeSpan;
    }

    public void setLifeSpan(String lifeSpan) {
        this.lifeSpan = lifeSpan;
    }

    public String getTemperament() {
        return temperament;
    }

    public void setTemperament(String temperament) {
        this.temperament = temperament;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Weight getWeight() {
        return weight;
    }

    public void setWeight(Weight weight) {
        this.weight = weight;
    }

    public Height getHeight() {
        return height;
    }

    public void setHeight(Height height) {
        this.height = height;
    }
}
