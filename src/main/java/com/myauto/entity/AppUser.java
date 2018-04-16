package com.myauto.entity;

import javax.persistence.*;

import com.myauto.ids.AppUserId;

import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "app_user")
@NoArgsConstructor
public class AppUser {

    @EmbeddedId
    @AttributeOverride(name = "value", column = @Column(name = "id"))
    private AppUserId id;
    
    @Column
    private String name;
    
    @Column
    private String email;
    
    @Builder
    public AppUser(AppUserId id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
    
    public String getName() {
        return this.name;
    }
}
