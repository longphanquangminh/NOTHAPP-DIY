package com.noth.nothapp.Model;

public class Discount {
    private int numberSale;
    private int imageSale;
    private String initialPrice;//giá ban đầu
    private String discountPrice;
    private int Sold;

    public Discount(int numberSale, int imageSale, String initialPrice, String discountPrice, int sold) {
        this.numberSale = numberSale;
        this.imageSale = imageSale;
        this.initialPrice = initialPrice;
        this.discountPrice = discountPrice;
        Sold = sold;
    }

    public int getNumberSale() {
        return numberSale;
    }

    public void setNumberSale(int numberSale) {
        this.numberSale = numberSale;
    }

    public int getImageSale() {
        return imageSale;
    }

    public void setImageSale(int imageSale) {
        this.imageSale = imageSale;
    }

    public String getInitialPrice() {
        return initialPrice;
    }

    public void setInitialPrice(String initialPrice) {
        this.initialPrice = initialPrice;
    }

    public String getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(String discountPrice) {
        this.discountPrice = discountPrice;
    }

    public int getSold() {
        return Sold;
    }

    public void setSold(int sold) {
        Sold = sold;
    }
}

