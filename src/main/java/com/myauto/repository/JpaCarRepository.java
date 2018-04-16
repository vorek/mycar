package com.myauto.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import com.myauto.entity.Car;
import com.myauto.ids.CarId;

public class JpaCarRepository implements CarRepository{
    private EntityManager entityManager;

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void add(Car car) {
        entityManager.persist(car);
    }

    @Override
    @Transactional
    public Car get(CarId carId) {
        return entityManager.find(Car.class, carId);
    }

}
