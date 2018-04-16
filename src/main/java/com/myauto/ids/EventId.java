package com.myauto.ids;

import com.myauto.tools.GenericId;
import com.myauto.tools.StringIdGenerator;

/**
 * 
 * @author ozaytsev
 * ИД события
 *
 */
public class EventId extends GenericId {
    public EventId() {
    }
    
    public EventId(String value) {
        super(value);
    }

    public static EventId newId() {
        return new EventId(StringIdGenerator.newId());
    }
    
    public static EventId fromString(String value) {
        return new EventId(value);
    }
}
