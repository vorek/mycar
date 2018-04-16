package com.myauto.entity;

import java.time.LocalDate;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.myauto.enums.EventType;
import com.myauto.ids.CarId;
import com.myauto.ids.EventId;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="event")
@Getter
@Setter
public class Event {

    @EmbeddedId
    @AttributeOverride(name = "value", column = @Column(name = "id"))
    private EventId id;

    /**
     * Дата
     */
    @Column
    private LocalDate data;

    /**
     * Тип события
     */
    @Column
    private EventType type;

    /**
     * Стомость
     */
    @Column
    private Double price;

    /**
     * Описание
     */
    @Column
    private String description;

    /**
     * Пробег
     */
    @Column
    private Long mileage;

    @AttributeOverride(name="value", column=@Column(name="car_id"))
    private CarId carId;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="car_id", insertable=false, updatable=false)
    private Car car;

    @Builder
    public Event(EventId id, LocalDate data, EventType type, Double price, String description, Long mileage, CarId carId) {
        this.id = id;
        this.data = data;
        this.type = type;
        this.price = price;
        this.description = description;
        this.mileage = mileage;
        this.carId = carId;
    }
}
