package com.myauto.dto;

import javax.persistence.Column;

import com.myauto.enums.FuelType;
import com.myauto.ids.AppUserId;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class AddCarRequest {
    @NonNull
    private AppUserId userId;

    /**
     * Марка автомобиля
     */
    @Column
    private String vendor;

    /**
     * Модель автомобиля
     */
    @Column
    private String model;

    /**
     * Год выпуска
     */
    @Column
    private Long year;

    /**
     * Пробег
     */
    @Column
    private Long mileage;

    /**
     * Тип топлива
     */
    @Column
    private FuelType fuelType;

    /**
     * VIN код
     */
    @Column
    private String vinCode;
}
