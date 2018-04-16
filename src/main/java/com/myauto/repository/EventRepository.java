package com.myauto.repository;

import com.myauto.entity.Event;
import com.myauto.ids.EventId;

/**
 * ”правление хранилищем событий
 * @author ozaytsev
 *
 */
public interface EventRepository {

    void add(Event event);
    
    Event get(EventId id);
}
