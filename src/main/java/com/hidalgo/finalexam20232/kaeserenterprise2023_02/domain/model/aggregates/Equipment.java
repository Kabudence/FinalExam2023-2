package com.hidalgo.finalexam20232.kaeserenterprise.domain.model.aggregates;

import com.hidalgo.finalexam20232.kaeserenterprise.domain.model.commands.CreateEquipmentCommand;
import com.hidalgo.finalexam20232.kaeserenterprise.domain.model.valueobjects.MaterialSerialNumber;
import com.hidalgo.finalexam20232.kaeserenterprise.domain.model.entities.EquipmentType;
import com.hidalgo.finalexam20232.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.util.UUID;

@Entity
public class Equipment extends AuditableAbstractAggregateRoot<Equipment> {

    @NotNull
    @Embedded
    private MaterialSerialNumber materialSerialNumber;

    
    @Getter
    @Size(max = 50)
    @NotBlank
    private String model;

    @ManyToOne
    @JoinColumn(name = "equipment_type_id", nullable = false)
    @NotNull
    private EquipmentType equipmentType;

    public Equipment(CreateEquipmentCommand command,EquipmentType equipmentTypeId) {
        this.materialSerialNumber = new MaterialSerialNumber(UUID.randomUUID());
        this.model = command.model();
        this.equipmentType = equipmentTypeId;

    }

    public Equipment() {

    }

    public String getEquipmentType() {
        return equipmentType.getName().toString();
    }

    public String getMaterialSerialNumberString() {
        return materialSerialNumber.getValueToString();
    }
    public UUID getMaterialSerialNumberUUID() {
        return materialSerialNumber.getUUID();
    }

}
