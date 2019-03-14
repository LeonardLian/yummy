package com.javaee.dao;

import com.javaee.entity.BankcardEntity;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 下午8:53 2019/3/5
 */
public interface BankcardDao {
    void createBankcard(BankcardEntity bankcard);

    void updateBankcard(String email, double consumeMoney, int state);

    BankcardEntity retrieveByBankcardId(String cardCode);

    BankcardEntity retrieveByEmail(String email);

    void deleteBankcard(String cardCode);
}
