package es.telefonica.talentum.ledapp;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by gemabeltran on 23/2/17.
 */

public class ProductResponse {

    @SerializedName("products") private List <Product> productList;

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
