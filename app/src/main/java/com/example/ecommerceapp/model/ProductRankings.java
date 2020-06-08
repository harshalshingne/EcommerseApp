package com.example.ecommerceapp.model;

import java.io.Serializable;

public class ProductRankings implements Serializable {
    private String ranking;
    private String products;

    public String getRanking() {
        return ranking;
    }

    public void setRanking(String ranking) {
        this.ranking = ranking;
    }

    public String getProducts() {
        return products;
    }

    public void setProducts(String products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "ProductRankings{" +
                "ranking='" + ranking + '\'' +
                ", products='" + products + '\'' +
                '}';
    }
}
