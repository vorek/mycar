package com.myauto.entity;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.myauto.enums.FuelType;
import com.myauto.ids.AppUserId;
import com.myauto.ids.CarId;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "car")
@Getter
@Setter
public class Car {

    @EmbeddedId
    @AttributeOverride(name = "value", column = @Column(name = "id"))
    private CarId id;

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

    @AttributeOverride(name="value", column=@Column(name="user_id"))
    private AppUserId userId;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id", insertable=false, updatable=false)
    private AppUser user;

    @OneToMany(fetch=FetchType.LAZY, mappedBy="car")
    private List<Event> events = new LinkedList<Event>();

    @Builder
    public Car(CarId id, String vendor, String model, Long year, Long mileage, FuelType fuelType, String vinCode, AppUserId userId) {
        this.id = id;
        this.vendor = vendor;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
        this.fuelType = fuelType;
        this.vinCode = vinCode;
        this.userId = userId;
    }
}
