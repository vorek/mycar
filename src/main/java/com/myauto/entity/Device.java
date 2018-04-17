package com.myauto.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.myauto.ids.AppUserId;
import com.myauto.ids.DeviceId;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "device")
@Getter
@Setter
public class Device {

    /**
     * Идентификатор устройства
     */
    @Id
    private DeviceId id;

    /**
     * Название устройства
     */
    @Column
    private String name;

    /**
     * Уникальный код устройства
     */
    @Column
    private String imei;
    
    @AttributeOverride(name="value", column=@Column(name="user_id"))
    private AppUserId userId;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id", insertable=false, updatable=false)
    private AppUser user;
    
    public Device() {
    }
    
    @Builder
    public Device (DeviceId id, String imei, String name, AppUserId userId) {
        this.id = DeviceId.newId();
        this.name = name;
        this.imei = imei;
        this.userId = userId;
    }
}
