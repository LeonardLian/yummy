package com.javaee.entity;

import com.alibaba.fastjson.annotation.JSONField;

import javax.persistence.*;


/**
 * @author: pis
 * @description: good good study
 * @date: create in 下午4:59 2019/3/5
 */
@Entity
@Table(name = "bankcard", schema = "yummy")
public class BankcardEntity {

    @JSONField(name = "cardid")
    private int cardid;

    @JSONField(name="email")
    private String email;

    @JSONField(name="cardcode")
    private String cardcode;

    @JSONField(name="money")
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
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
                email.equals(that.email) &&
                Double.compare(that.money, money) == 0 &&
                cardcode.equals(that.cardcode);
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(cardid, userid, cardcode, money);
//    }
}
