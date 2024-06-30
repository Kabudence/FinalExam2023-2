package com.hidalgo.finalexam20232.kaeserenterprise.domain.model.commands;

import com.hidalgo.finalexam20232.kaeserenterprise.domain.model.valueobjects.EquipmentTypes;

public record CreateEquipmentCommand(String model,
                                     EquipmentTypes equipmentType) {
}
