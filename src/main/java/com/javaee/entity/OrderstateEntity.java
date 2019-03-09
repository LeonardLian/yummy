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
@Table(name = "orderstate", schema = "yummy")
public class OrderstateEntity {

    @JSONField(name = "orderid")
    private int orderid;

    @JSONField(name="orderstate")
    private String orderstate;

    @JSONField(name = "paytime", format = "yyyy-MM-dd HH:mm:ss")
    private Timestamp paytime;

    @JSONField(name = "canceltime", format = "yyyy-MM-dd HH:mm:ss")
    private Timestamp canceltime;

    @JSONField(name = "arrivetime", format = "yyyy-MM-dd HH:mm:ss")
    private Timestamp arrivetime;

    @Id
    @Column(name = "orderid")
    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    @Basic
    @Column(name = "orderstate")
    public String getOrderstate() {
        return orderstate;
    }

    public void setOrderstate(String orderstate) {
        this.orderstate = orderstate;
    }

    @Basic
    @Column(name = "paytime")
    public Timestamp getPaytime() {
        return paytime;
    }

    public void setPaytime(Timestamp paytime) {
        this.paytime = paytime;
    }

    @Basic
    @Column(name = "canceltime")
    public Timestamp getCanceltime() {
        return canceltime;
    }

    public void setCanceltime(Timestamp canceltime) {
        this.canceltime = canceltime;
    }

    @Basic
    @Column(name = "arrivetime")
    public Timestamp getArrivetime() {
        return arrivetime;
    }

    public void setArrivetime(Timestamp arrivetime) {
        this.arrivetime = arrivetime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderstateEntity that = (OrderstateEntity) o;
        return orderid == that.orderid &&
                orderstate.equals(that.orderstate) &&
                paytime.equals(that.paytime) &&
                canceltime.equals(that.canceltime) &&
                arrivetime.equals(that.arrivetime);
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(orderid, orderstate, paytime, canceltime, arrivetime);
//    }
}
