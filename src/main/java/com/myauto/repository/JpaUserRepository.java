package com.myauto.repository;

import java.util.List;

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

    @Override
    @Transactional
    public AppUser findUserByEmail(String email) {
        List<AppUser> users = entityManager.createQuery("select u from AppUser u where u.email=:email", AppUser.class).setParameter("email", email).getResultList();
        return users.stream().findFirst().orElse(null);
    }
}
