package com.noth.nothapp.Model;

public class Category {
    //Phân loại sản phẩm
    private String nameCategory;

    public Category(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public Category() {
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }
}

