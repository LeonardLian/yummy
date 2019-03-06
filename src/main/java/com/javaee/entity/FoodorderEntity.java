package com.javaee.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 上午9:32 2019/3/5
 */
@Entity
@Table(name = "foodorder", schema = "yummy", catalog = "")
public class FoodorderEntity {
    private int orderid;
    private int userid;
    private String restCode;
    private String useraddress;
    private String packageids;
    private String packagenums;
    private String foodCodes;
    private String foodNums;
    private double totalprice;

    @Id
    @Column(name = "orderid")
    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    @Basic
    @Column(name = "userid")
    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
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
    @Column(name = "useraddress")
    public String getUseraddress() {
        return useraddress;
    }

    public void setUseraddress(String useraddress) {
        this.useraddress = useraddress;
    }

    @Basic
    @Column(name = "packageids")
    public String getPackageids() {
        return packageids;
    }

    public void setPackageids(String packageids) {
        this.packageids = packageids;
    }

    @Basic
    @Column(name = "packagenums")
    public String getPackagenums() {
        return packagenums;
    }

    public void setPackagenums(String packagenums) {
        this.packagenums = packagenums;
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
    @Column(name = "totalprice")
    public double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(double totalprice) {
        this.totalprice = totalprice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FoodorderEntity that = (FoodorderEntity) o;
        return orderid == that.orderid &&
                userid == that.userid &&
                Double.compare(that.totalprice, totalprice) == 0 &&
                Objects.equals(restCode, that.restCode) &&
                Objects.equals(useraddress, that.useraddress) &&
                Objects.equals(packageids, that.packageids) &&
                Objects.equals(packagenums, that.packagenums) &&
                Objects.equals(foodCodes, that.foodCodes) &&
                Objects.equals(foodNums, that.foodNums);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderid, userid, restCode, useraddress, packageids, packagenums, foodCodes, foodNums, totalprice);
    }
}
