package com.javaee.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 上午9:32 2019/3/5
 */
@Entity
@Table(name = "food", schema = "yummy", catalog = "")
public class FoodEntity {
    private int foodid;
    private String restCode;
    private double price;
    private int number;

    @Id
    @Column(name = "foodid")
    public int getFoodid() {
        return foodid;
    }

    public void setFoodid(int foodid) {
        this.foodid = foodid;
    }

    @Basic
    @Column(name = "restCode")
    public String getRestCode() {
        return restCode;
    }

    public void setRestCode(String restCode) {
        this.restCode = restCode;
    }

    @Basic
    @Column(name = "price")
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Basic
    @Column(name = "number")
    public int getNumber() { return number; }

    public void setNumber(int number) { this.number = number; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FoodEntity that = (FoodEntity) o;
        return foodid == that.foodid &&
                Double.compare(that.price, price) == 0 &&
                Objects.equals(restCode, that.restCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(foodid, restCode, price);
    }
}
