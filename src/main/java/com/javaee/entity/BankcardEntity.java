package com.javaee.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 下午4:59 2019/3/5
 */
@Entity
@Table(name = "bankcard", schema = "yummy", catalog = "")
public class BankcardEntity {
    private int cardid;
    private int userid;
    private String cardcode;
    private double money;

    @Id
    @Column(name = "cardid")
    public int getCardid() {
        return cardid;
    }

    public void setCardid(int cardid) {
        this.cardid = cardid;
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
    @Column(name = "cardcode")
    public String getCardcode() {
        return cardcode;
    }

    public void setCardcode(String cardcode) {
        this.cardcode = cardcode;
    }

    @Basic
    @Column(name = "money")
    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankcardEntity that = (BankcardEntity) o;
        return cardid == that.cardid &&
                userid == that.userid &&
                Double.compare(that.money, money) == 0 &&
                Objects.equals(cardcode, that.cardcode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardid, userid, cardcode, money);
    }
}
