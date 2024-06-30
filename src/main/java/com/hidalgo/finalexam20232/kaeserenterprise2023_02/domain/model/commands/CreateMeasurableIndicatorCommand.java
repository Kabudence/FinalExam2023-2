package com.hidalgo.finalexam20232.kaeserenterprise.domain.model.commands;

import com.hidalgo.finalexam20232.kaeserenterprise.domain.model.valueobjects.EquipmentTypes;

public record CreateMeasurableIndicatorCommand(String symbol,
                                               String description,
                                               Double thresholdMinimum,
                                               Double thresholdMaximum,
                                               EquipmentTypes equipmentType) {
}
