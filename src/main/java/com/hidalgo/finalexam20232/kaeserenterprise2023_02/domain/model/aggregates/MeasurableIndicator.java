package com.hidalgo.finalexam20232.kaeserenterprise.domain.model.aggregates;

import com.hidalgo.finalexam20232.kaeserenterprise.domain.model.commands.CreateMeasurableIndicatorCommand;
import com.hidalgo.finalexam20232.kaeserenterprise.domain.model.entities.EquipmentType;
import com.hidalgo.finalexam20232.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Entity
public class MeasurableIndicator extends AuditableAbstractAggregateRoot<MeasurableIndicator> {


    @Getter
    @Size(max = 50)
    @NotBlank
    private String symbol;

    @Getter
    @Size(max = 150)
    @NotBlank
    private String description;

    @Getter
    @Min(0)
    private Double thresholdMinimum;

    @Getter
    @Min(1)
    private Double thresholdMaximum;

    @ManyToOne
    @JoinColumn(name = "equipment_type_id", nullable = false)
    @NotNull
    private EquipmentType equipmentType;

    public MeasurableIndicator(CreateMeasurableIndicatorCommand command, EquipmentType equipmentTypeId){
        this.symbol = command.symbol();
        this.description = command.description();
        this.thresholdMinimum = command.thresholdMinimum();
        this.thresholdMaximum = command.thresholdMaximum();
        this.equipmentType = equipmentTypeId;
    }

    public MeasurableIndicator() {

    }

    public String getEquipmentType() {
        return equipmentType.getName().toString();
    }





}
