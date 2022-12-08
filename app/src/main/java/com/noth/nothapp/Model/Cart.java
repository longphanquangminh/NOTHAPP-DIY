package com.noth.nothapp.Model;

public class Cart {
    private int imgCart;
    private String nameProduct;
    private int priceProduct;
    private int numberProduct;

    public Cart(int imgCart, String nameProduct, int priceProduct, int numberProduct) {
        this.imgCart = imgCart;
        this.nameProduct = nameProduct;
        this.priceProduct = priceProduct;
        this.numberProduct = numberProduct;
    }

    public int getImgCart() {
        return imgCart;
    }

    public void setImgCart(int imgCart) {
        this.imgCart = imgCart;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public int getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(int priceProduct) {
        this.priceProduct = priceProduct;
    }

    public int getNumberProduct() {
        return numberProduct;
    }

    public void setNumberProduct(int numberProduct) {
        this.numberProduct = numberProduct;
    }
}
