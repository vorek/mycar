package com.myauto.listeners;

import java.io.Serializable;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@EntityListeners({AbstractEntityListener.class})
public abstract class AbstractEntity implements Serializable {
    
}
