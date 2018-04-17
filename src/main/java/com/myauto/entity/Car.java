package com.myauto.entity;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
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

    @AttributeOverride(name="value", column=@Column(name="user_id"))
    private AppUserId userId;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id", insertable=false, updatable=false)
    private AppUser user;

    @OneToMany(fetch=FetchType.LAZY, mappedBy="car", cascade = CascadeType.ALL)
    private List<Event> events = new LinkedList<Event>();

    public Car() {
    }

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
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car that = (Car) o;

        return vinCode != null ? vinCode.equals(that.vinCode) : that.vinCode == null;
    }

    @Override
    public int hashCode() {
        int result = (year != null ? year.intValue() : 0);
        result = 31 * result + (mileage != null ? mileage.intValue() : 0);
        result = 31 * result + (vinCode != null ? vinCode.hashCode() : 0);
        return result;
    }
}
