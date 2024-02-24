package com.example.geraicafe;

public class Data {
    int imagesProduct, id;
    String priceProduct;
    String nameProduct;
    public Data(){

    }
    public Data(int id, String nameProduct, String priceProduct, int imagesProduct){
        this.id = id;
        this.nameProduct = nameProduct;
        this.priceProduct = priceProduct;
        this.imagesProduct = imagesProduct;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setImagesProduct(int imagesProduct) {
        this.imagesProduct = imagesProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public void setPriceProduct(String priceProduct) {
        this.priceProduct = priceProduct;
    }

    public int getImagesProduct() {
        return imagesProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public String getPriceProduct() {
        return priceProduct;
    }
}
