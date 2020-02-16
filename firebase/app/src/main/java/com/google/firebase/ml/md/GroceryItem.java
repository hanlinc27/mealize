package com.google.firebase.ml.md;

import java.io.Serializable;

class GroceryItem implements Serializable {
    String name;
    int price;
    String imageURL;
    GroceryItem(String name, int price, String imageURL) {
        this.name = name;
        this.price = price;
        this.imageURL = imageURL;
    }
}
