package com.javaee.entity;

import com.alibaba.fastjson.annotation.JSONField;

import javax.persistence.*;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 下午7:27 2019/3/10
 */
@Entity
@Table(name = "user", schema = "yummy")
public class UserEntity {

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
        return level == that.level &&
                email.equals(that.email) &&
                phone.equals(that.phone) &&
                name.equals(that.name) &&
                addresses.equals(that.addresses);
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(email, phone, name, addresses, level);
//    }
}
