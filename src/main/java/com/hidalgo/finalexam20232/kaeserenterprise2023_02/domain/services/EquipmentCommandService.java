package com.hidalgo.finalexam20232.kaeserenterprise.domain.services;

import com.hidalgo.finalexam20232.kaeserenterprise.domain.model.aggregates.Equipment;
import com.hidalgo.finalexam20232.kaeserenterprise.domain.model.commands.CreateEquipmentCommand;

import java.util.Optional;

public interface EquipmentCommandService {

    Optional<Equipment> handle(CreateEquipmentCommand command);

}
