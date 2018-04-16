package com.myauto.tools;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonValue;

@MappedSuperclass
public class GenericId implements Serializable, StringValueWrapper {

    protected String value;

    public GenericId(String value) {
        this.value = value;
    }

    public GenericId() {
    }

    public boolean notSet() {
        return StringUtils.isEmpty(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GenericId genericId = (GenericId) o;

        return value != null ? value.equals(genericId.value) : genericId.value == null;
    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }

    @JsonValue
    public String asString() {
        return value;
    }

    @Override
    public String toString() {
        return "GenericId{" +
                "value='" + value + '\'' +
                '}';
    }
}
