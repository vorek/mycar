package com.myauto.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.myauto.entity.AppUser;
import com.myauto.ids.AppUserId;

@Repository
public class JpaUserRepository implements UserRepository {
    private EntityManager entityManager;

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void add(AppUser user) {
        entityManager.persist(user);
    }

    @Override
    @Transactional
    public AppUser get(AppUserId id) {
        return entityManager.find(AppUser.class, id);
    }
    
}
