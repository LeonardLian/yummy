package com.javaee.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 上午9:32 2019/3/5
 */
@Entity
@Table(name = "restaurant", schema = "yummy", catalog = "")
public class RestaurantEntity {
    private String code;
    private String password;
    private String address;
    private String kind;
    private int state;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RestaurantEntity that = (RestaurantEntity) o;
        return state == that.state &&
                Objects.equals(code, that.code) &&
                Objects.equals(password, that.password) &&
                Objects.equals(address, that.address) &&
                Objects.equals(kind, that.kind);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, password, address, kind, state);
    }
}
