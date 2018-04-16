package com.myauto.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.myauto.ids.AppUserId;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "app_user")
@Getter
@Setter
public class AppUser {

    @EmbeddedId
    @AttributeOverride(name = "value", column = @Column(name = "id"))
    private AppUserId id;
    
    @Column
    private String name;
    
    @Column
    private String email;
    
    @OneToMany(fetch=FetchType.LAZY, mappedBy="user", cascade = CascadeType.ALL)
    private Set<Car> cars = new HashSet<Car>(); 

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
