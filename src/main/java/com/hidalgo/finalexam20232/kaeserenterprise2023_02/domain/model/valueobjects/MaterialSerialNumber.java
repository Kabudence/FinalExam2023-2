package com.hidalgo.finalexam20232.kaeserenterprise.domain.model.valueobjects;

import jakarta.persistence.Embeddable;
import java.util.UUID;

@Embeddable
public class MaterialSerialNumber {
    private final UUID value;

    // Constructor for JPA
    protected MaterialSerialNumber() {
        this.value = UUID.randomUUID();
    }

    public MaterialSerialNumber(UUID value) {
        this.value = value;
    }

    public String getValueToString() {
        return value.toString();
    }

    public UUID getUUID() {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MaterialSerialNumber that = (MaterialSerialNumber) o;

        return value.equals(that.value);
    }


}
