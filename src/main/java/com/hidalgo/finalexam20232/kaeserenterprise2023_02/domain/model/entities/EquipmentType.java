package com.hidalgo.finalexam20232.kaeserenterprise.domain.model.entities;

import com.hidalgo.finalexam20232.kaeserenterprise.domain.model.valueobjects.EquipmentTypes;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
public class EquipmentType {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Enumerated(EnumType.STRING)
    @Column(length = 30, nullable = false, unique = true)
    private EquipmentTypes name;

    public EquipmentType() {
    }

    public EquipmentType(EquipmentTypes equipmentTypes){this.name = equipmentTypes;}



}
