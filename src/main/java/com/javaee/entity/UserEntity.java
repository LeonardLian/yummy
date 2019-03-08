package com.javaee.entity;

import com.alibaba.fastjson.annotation.JSONField;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 上午9:32 2019/3/5
 */
@Entity
@Table(name = "user", schema = "yummy", catalog = "")
public class UserEntity {

    @JSONField(name = "userid")
    private int userid;

    @JSONField(name = "email")
    private String email;

    @JSONField(name = "phone")
    private String phone;

    @JSONField(name = "name")
    private String name;

    @JSONField(name = "addresses")
    private String addresses;

    @JSONField(name = "level")
    private int level;

    @Id
    @Column(name = "userid")
    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
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
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
    @Column(name = "addresses")
    public String getAddresses() {
        return addresses;
    }

    public void setAddresses(String addresses) {
        this.addresses = addresses;
    }

    @Basic
    @Column(name = "level")
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return userid == that.userid &&
                level == that.level &&
                Objects.equals(email, that.email) &&
                Objects.equals(phone, that.phone) &&
                Objects.equals(name, that.name) &&
                Objects.equals(addresses, that.addresses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userid, email, phone, name, addresses, level);
    }
}
