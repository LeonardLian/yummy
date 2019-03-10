package com.javaee.dao.impl;

import com.javaee.dao.BankcardDao;
import com.javaee.entity.BankcardEntity;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * @author: pis
 * @description: good good study
 * @date: create in 下午8:53 2019/3/5
 */

@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW )
public class BankcardDaoImpl extends HibernateDaoSupport implements BankcardDao{


    public void createBankcard(BankcardEntity bankcard) {
        this.getHibernateTemplate().save(bankcard);
    }

    // state 0扣钱 1加钱
    public void updateBankcard(String cardCode, double consumeMoney, int state) {
        String hql="from BankcardEntity where cardcode = ?0";
        List list=this.getHibernateTemplate().find(hql,cardCode);
        double oldMoney=((BankcardEntity)list.get(0)).getMoney();

        if(state==0){
            oldMoney=oldMoney-consumeMoney;
        }else if(state==1){
            oldMoney=oldMoney+consumeMoney;
        }else {}

        ((BankcardEntity)list.get(0)).setMoney(oldMoney);

        this.getHibernateTemplate().update(list.get(0));

    }

    public BankcardEntity retrieveByBankcardId(String cardCode) {
        String hql="from BankcardEntity where cardcode = ?0";
        List list=this.getHibernateTemplate().find(hql,cardCode);
        return (BankcardEntity)list.get(0);
    }

    public void deleteBankcard(String cardCode) {
        String hql="from BankcardEntity where cardcode = ?0";
        List list=this.getHibernateTemplate().find(hql,cardCode);
        this.getHibernateTemplate().delete(list.get(0));
    }
}
