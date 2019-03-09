package com.javaee.entity;

import com.alibaba.fastjson.annotation.JSONField;

import javax.persistence.*;
import java.sql.Timestamp;


/**
 * @author: pis
 * @description: good good study
 * @date: create in 上午9:32 2019/3/5
 */
@Entity
@Table(name = "foodorder", schema = "yummy")
public class FoodorderEntity {

    @JSONField(name="orderid")
    private int orderid;

    @JSONField(name = "userid")
    private int userid;

    @JSONField(name="restCode")
    private String restCode;

    @JSONField(name="useraddress")
    private String useraddress;

    @JSONField(name="packageids")
    private String packageids;

    @JSONField(name="packagenums")
    private String packagenums;

    @JSONField(name="foodCodes")
    private String foodCodes;

    @JSONField(name="foodNums")
    private String foodNums;

    @JSONField(name = "totalprice")
    private double totalprice;

    @JSONField(name = "buildtime", format = "yyyy-MM-dd HH:mm:ss")
    private Timestamp buildtime;

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

    @Basic
    @Column(name = "buildtime")
    public Timestamp getBuildtime() {
        return buildtime;
    }

    public void setBuildtime(Timestamp buildtime) {
        this.buildtime = buildtime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FoodorderEntity that = (FoodorderEntity) o;
        return orderid == that.orderid &&
                userid == that.userid &&
                Double.compare(that.totalprice, totalprice) == 0 &&
                restCode.equals(that.restCode) &&
                useraddress.equals(that.useraddress) &&
                packageids.equals(that.packageids) &&
                packagenums.equals(that.packagenums) &&
                foodCodes.equals(that.foodCodes) &&
                foodNums.equals(that.foodNums);
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(orderid, userid, restCode, useraddress, packageids, packagenums, foodCodes, foodNums, totalprice);
//    }

}
