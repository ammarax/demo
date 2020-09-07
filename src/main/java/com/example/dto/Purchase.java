package com.example.dto;

import com.example.model.Book;
import com.example.model.Food;
import com.example.model.Medical;

public class Purchase {

    Double tax;
    Double value;
    Boolean imported;
    String name;
    Integer qta;

    public Purchase(String name, Integer qta, Double value) {

        this.value = value;
        this.name = name;
        this.qta = qta;
        this.imported = name.contains("imported");
        this.tax = this.calcTax();
    }

    @Override
    public String toString() {
        return qta + " " + name +": " + String.format("%.2f", this.getTaxesValue());
    }

    private Double calcTax() {
        Double tax = 0.1;
        if (this.isBook() || this.isFood() || this.isMedical())
            tax = 0.0;
        if (this.imported)
            tax += 0.05;
        return tax;
    }

    public boolean isFood() {
        Food f = Food.find(this.name);
        return f != null ? true :false;
    }
    public boolean isMedical() {
        Medical f = Medical.find(this.name);
        return f != null ? true :false;
    }
    public boolean isBook() {
        Book f = Book.find(this.name);
        return f != null ? true :false;
    }
    public double getTaxesValue() {
        Double val = value + this.getTax();
        return val;
    }public double getTax() {
        Double val = value * tax;
        return  Math.round(val * 20.0) / 20.0;
    }
}
