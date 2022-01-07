package com.modelPackage;

//This class define the Product Model and it has hardcoded dataset

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class ProductListModel {
    public int productID;
    public String productName;
    public double productPrice;
    public String imageSrc;

    public ProductListModel(){}

    public static List<ProductListModel> productLists = Arrays.asList(
            new ProductListModel(1,"Hp Laptpop",55000,"./images/product1.jpg"),
            new ProductListModel(2,"Dell Laptpop",50000,"./images/product2.jpg"),
            new ProductListModel(3,"Realme Phone",25000,"./images/phone.jpg"),
            new ProductListModel(4,"Keyboard",400,"./images/keyboard.jpg")
    );
    public ProductListModel(int productID, String productName, double productPrice, String imageSrc) {
        this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;
        this.imageSrc = imageSrc;
    }

}
