package com.javaee.entity;

import com.alibaba.fastjson.annotation.JSONField;

import javax.persistence.*;


/**
 * @author: pis
 * @description: good good study
 * @date: create in 上午9:32 2019/3/5
 */
@Entity
@Table(name = "food", schema = "yummy")
public class FoodEntity {

    @JSONField(name="foodid")
    private int foodid;

    @JSONField(name="restCode")
    private String restCode;

    @JSONField(name="price")
    private double price;

    @JSONField(name="number")
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
                restCode.equals(that.restCode);
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(foodid, restCode, price);
//    }
}
