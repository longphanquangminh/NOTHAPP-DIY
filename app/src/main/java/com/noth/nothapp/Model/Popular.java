package com.noth.nothapp.Model;

import java.io.Serializable;

public class Popular implements Serializable {
    private String namePopular;
    private int imgPopular;
    private float rating;
    private int moneyPopular;

    public Popular(String namePopular, int imgPopular, float rating, int moneyPopular) {
        this.namePopular = namePopular;
        this.imgPopular = imgPopular;
        this.rating = rating;
        this.moneyPopular = moneyPopular;
    }

    public Popular() {
    }

    public String getNamePopular() {
        return namePopular;
    }

    public void setNamePopular(String namePopular) {
        this.namePopular = namePopular;
    }

    public int getImgPopular() {
        return imgPopular;
    }

    public void setImgPopular(int imgPopular) {
        this.imgPopular = imgPopular;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getMoneyPopular() {
        return moneyPopular;
    }

    public void setMoneyPopular(int moneyPopular) {
        this.moneyPopular = moneyPopular;
    }
}

