package com.example.myapplication;

import java.io.Serializable;

public class Data implements Serializable {
    private final String food_name;
    private final String food_type;
    private final String food_isspicy;
    private final String food_isprice;
    private final String food_issoup;
    private final String food_isfast;
    private final String food_ismeat;
    private final String food_isheavy;
    private final String food_ishot;
    private final String food_isrice;
    private final String food_isfried;

    public Data(String food_name, String food_type, String food_isspicy, String food_isprice, String food_issoup, String food_isfast, String food_ismeat, String food_isheavy, String food_ishot, String food_isrice, String food_isfried) {
        this.food_name = food_name;
        this.food_type = food_type;
        this.food_isspicy = food_isspicy;
        this.food_isprice = food_isprice;
        this.food_issoup = food_issoup;
        this.food_isfast = food_isfast;
        this.food_ismeat = food_ismeat;
        this.food_isheavy = food_isheavy;
        this.food_ishot = food_ishot;
        this.food_isrice = food_isrice;
        this.food_isfried = food_isfried;
    }

    public String getFood_name() {
        return  food_name;
    }
    public String getFood_type() {
        return  food_type;
    }
    public String getFood_isspicy() {
        return food_isspicy;
    }
    public String getFood_isprice() {
        return food_isprice;
    }
    public String getFood_issoup() {
        return  food_issoup;
    }
    public String getFood_isfast() {
        return  food_isfast;
    }
    public String getFood_ismeat() {
        return  food_ismeat;
    }
    public String getFood_isheavy() {
        return  food_isheavy;
    }
    public String getFood_ishot() {
        return  food_ishot;
    }
    public String getFood_isrice() {
        return food_isrice;
    }
    public String getFood_isfried() {
        return  food_isfried;
    }

}
