package com.myauto.repository;

import com.myauto.entity.Car;
import com.myauto.ids.CarId;

/**
 * ���������� ���������� �����������
 * @author ozaytsev
 *
 */
public interface CarRepository {

    void add(Car car);
    
    Car get(CarId carId);

    Car findCarByVinCode(String vinCode);
}
