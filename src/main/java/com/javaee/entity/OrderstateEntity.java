package com.javaee.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 上午9:32 2019/3/5
 */
@Entity
@Table(name = "orderstate", schema = "yummy", catalog = "")
public class OrderstateEntity {
    private int orderid;
    private String orderstate;
    private Timestamp paytime;
    private Timestamp canceltime;
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
                Objects.equals(orderstate, that.orderstate) &&
                Objects.equals(paytime, that.paytime) &&
                Objects.equals(canceltime, that.canceltime) &&
                Objects.equals(arrivetime, that.arrivetime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderid, orderstate, paytime, canceltime, arrivetime);
    }
}
