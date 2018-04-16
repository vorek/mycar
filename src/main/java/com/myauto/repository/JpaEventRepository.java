package com.myauto.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.myauto.entity.Event;
import com.myauto.ids.EventId;

@Repository
public class JpaEventRepository implements EventRepository {
    private EntityManager entityManager;

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void add(Event event) {
        entityManager.persist(event);
    }

    @Override
    @Transactional
    public Event get(EventId id) {
        return entityManager.find(Event.class, id);
    }
}
