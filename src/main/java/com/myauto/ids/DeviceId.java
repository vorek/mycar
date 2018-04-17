package com.myauto.ids;

import javax.persistence.Embeddable;

import com.myauto.tools.GenericId;
import com.myauto.tools.StringIdGenerator;

/**
 * Идентификатор мобильного устройства
 * @author ozaytsev
 *
 */
@Embeddable
public class DeviceId extends GenericId {
    public DeviceId() {
    }
    
    public DeviceId(String value) {
        super(value);
    }

    public static DeviceId newId() {
        return new DeviceId(StringIdGenerator.newId());
    }
    
    public static DeviceId fromString(String value) {
        return new DeviceId(value);
    }
}
