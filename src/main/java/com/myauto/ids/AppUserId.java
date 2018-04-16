package com.myauto.ids;

import javax.persistence.Embeddable;

import com.myauto.tools.GenericId;
import com.myauto.tools.StringIdGenerator;

/**
 * 
 * @author ozaytsev
 * ИД пользователя
 *
 */
@Embeddable
public class AppUserId extends GenericId {
    
    public AppUserId() {
    }
    
    public AppUserId(String value) {
        super(value);
    }

    public static AppUserId newId() {
        return new AppUserId(StringIdGenerator.newId());
    }
    
    public static AppUserId fromString(String value) {
        return new AppUserId(value);
    }
}
