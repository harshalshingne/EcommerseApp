package com.example.ecommerceapp.model;

import java.io.Serializable;
import java.util.List;

public class Products implements Serializable {
    private int id;
    private String name;
    private String date_added;
    private List<Variants> variants = null;
    private Tax tax;
    public static class Tax implements Serializable{
        public String name;
        public float value;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public float getValue() {
            return value;
        }

        public void setValue(float value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Tax{" +
                    "name='" + name + '\'' +
                    ", value=" + value +
                    '}';
        }
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate_added() {
        return date_added;
    }

    public void setDate_added(String date_added) {
        this.date_added = date_added;
    }

    public List<Variants> getVariants() {
        return variants;
    }

    public void setVariants(List<Variants> variants) {
        this.variants = variants;
    }

    public Tax getTax() {
        return tax;
    }

    public void setTax(Tax tax) {
        this.tax = tax;
    }

    @Override
    public String toString() {
        return "Products{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date_added='" + date_added + '\'' +
                ", variants=" + variants +
                ", tax=" + tax +
                '}';
    }
}
