package com.myauto.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.myauto.entity.Device;
import com.myauto.ids.DeviceId;

@Repository
public class JpaDeviceRepository implements DeviceRepository {
    private EntityManager entityManager;

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void add(Device device) {
        entityManager.persist(device);
    }

    @Override
    @Transactional
    public Device get(DeviceId id) {
        return entityManager.find(Device.class, id);
    }

    @Override
    @Transactional
    public Device findDeviceByImei(String deviceImei) {
        return entityManager.createQuery("select d from Device d where d.imei=:imei", Device.class)
                .setParameter("imei", deviceImei)
                .getResultList().stream().findFirst().orElse(null);
    }

}
