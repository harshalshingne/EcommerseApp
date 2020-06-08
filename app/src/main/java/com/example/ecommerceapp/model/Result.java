package com.example.ecommerceapp.model;

import java.io.Serializable;
import java.util.List;

public class Result implements Serializable {
    private List<Categories> categories = null;
   // private List<ProductRankings> rankings = null;

    public List<Categories> getCategories() {
        return categories;
    }

    public void setCategories(List<Categories> categories) {
        this.categories = categories;
    }

//    public List<ProductRankings> getRankings() {
//        return rankings;
//    }
//
//    public void setRankings(List<ProductRankings> rankings) {
//        this.rankings = rankings;
//    }


    @Override
    public String toString() {
        return "Result{" +
                "categories=" + categories +
                '}';
    }
}
