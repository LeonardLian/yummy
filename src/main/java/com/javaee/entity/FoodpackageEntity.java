package com.javaee.entity;

import com.alibaba.fastjson.annotation.JSONField;

import javax.persistence.*;


/**
 * @author: pis
 * @description: good good study
 * @date: create in 上午9:32 2019/3/5
 */
@Entity
@Table(name = "foodpackage", schema = "yummy")
public class FoodpackageEntity {

    @JSONField(name = "packageid")
    private int packageid;

    @JSONField(name = "restCode")
    private String restCode;

    @JSONField(name = "name")
    private String name;

    @JSONField(name = "foodCodes")
    private String foodCodes;

    @JSONField(name = "foodNums")
    private String foodNums;

    @JSONField(name = "price")
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
                restCode.equals(that.restCode) &&
                name.equals(that.name) &&
                foodCodes.equals(that.foodCodes) &&
                foodNums.equals(that.foodNums);
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(packageid, restCode, name, foodCodes, foodNums, price);
//    }
}
