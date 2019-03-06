package com.javaee.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 上午9:32 2019/3/5
 */
@Entity
@Table(name = "foodpackage", schema = "yummy", catalog = "")
public class FoodpackageEntity {
    private int packageid;
    private String restCode;
    private String name;
    private String foodCodes;
    private String foodNums;
    private double price;

    @Id
    @Column(name = "packageid")
    public int getPackageid() {
        return packageid;
    }

    public void setPackageid(int packageid) {
        this.packageid = packageid;
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
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "foodCodes")
    public String getFoodCodes() {
        return foodCodes;
    }

    public void setFoodCodes(String foodCodes) {
        this.foodCodes = foodCodes;
    }

    @Basic
    @Column(name = "foodNums")
    public String getFoodNums() {
        return foodNums;
    }

    public void setFoodNums(String foodNums) {
        this.foodNums = foodNums;
    }

    @Basic
    @Column(name = "price")
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FoodpackageEntity that = (FoodpackageEntity) o;
        return packageid == that.packageid &&
                Double.compare(that.price, price) == 0 &&
                Objects.equals(restCode, that.restCode) &&
                Objects.equals(name, that.name) &&
                Objects.equals(foodCodes, that.foodCodes) &&
                Objects.equals(foodNums, that.foodNums);
    }

    @Override
    public int hashCode() {
        return Objects.hash(packageid, restCode, name, foodCodes, foodNums, price);
    }
}
