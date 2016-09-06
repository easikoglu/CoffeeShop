package com.coffeeshop.example.dao;

import com.coffeeshop.example.models.user.jpa.UserJpaEntity;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 * Created by easikoglu on 30/01/16.
 */
@Repository
public class UserDaoImpl extends GenericDaoImpl<UserJpaEntity, Long> implements UserDao {
    @Override
    public UserJpaEntity findByName(String name) {

        Criteria criteria = currentSession().createCriteria(UserJpaEntity.class);
        criteria.add(Restrictions.eq("name", name));
        return (UserJpaEntity) criteria.uniqueResult();
    }
}
