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
     * ����� ����������
     */
    @Column
    private String vendor;

    /**
     * ������ ����������
     */
    @Column
    private String model;

    /**
     * ��� �������
     */
    @Column
    private Long year;

    /**
     * ������
     */
    @Column
    private Long mileage;

    /**
     * ��� �������
     */
    @Column
    private FuelType fuelType;

    /**
     * VIN ���
     */
    @Column
    private String vinCode;
}
