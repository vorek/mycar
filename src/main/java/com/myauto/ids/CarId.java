package com.myauto.ids;

import javax.persistence.Embeddable;

import com.myauto.tools.GenericId;
import com.myauto.tools.StringIdGenerator;

/**
 * 
 * @author ozaytsev
 * ИД автомобиля
 *
 */
@Embeddable
public class CarId extends GenericId {
    public CarId() {
    }
    
    public CarId(String value) {
        super(value);
    }

    public static CarId newId() {
        return new CarId(StringIdGenerator.newId());
    }
    
    public static CarId fromString(String value) {
        return new CarId(value);
    }

}
