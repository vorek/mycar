package com.myauto.repository;

import com.myauto.entity.Device;
import com.myauto.ids.DeviceId;

/**
 * ���������� ���������� ���������
 * @author ozaytsev
 *
 */
public interface DeviceRepository {

    void add(Device device);
    
    Device get(DeviceId id);

    Device findDeviceByImei(String deviceImei);
}
