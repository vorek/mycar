package com.myauto.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.myauto.entity.Car;
import com.myauto.entity.Device;
import com.myauto.ids.CarId;

@Repository
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

    @Override
    @Transactional
    public Car findCarByVinCode(String vinCode) {
        return entityManager.createQuery("select c from Car c where c.vinCode=:vinCode", Car.class)
                .setParameter("vinCode", vinCode)
                .getResultList().stream().findFirst().orElse(null);
    }

}
