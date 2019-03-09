package com.javaee.entity;

import com.alibaba.fastjson.annotation.JSONField;

import javax.persistence.*;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 上午9:32 2019/3/5
 */
@Entity
@Table(name = "restaurant", schema = "yummy")
public class RestaurantEntity {

    @JSONField(name = "code")
    private String code;

    @JSONField(name="password")
    private String password;

    @JSONField(name = "address")
    private String address;

    @JSONField(name="kind")
    private String kind;

    @JSONField(name = "state")
    private int state;

    @JSONField(name = "name")
    private String name;

    @Id
    @Column(name = "code")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "kind")
    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    @Basic
    @Column(name = "state")
    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RestaurantEntity that = (RestaurantEntity) o;
        return state == that.state &&
                code.equals(that.code) &&
                password.equals(that.password) &&
                address.equals(that.address) &&
                kind.equals(that.kind);
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(code, password, address, kind, state);
//    }
}
