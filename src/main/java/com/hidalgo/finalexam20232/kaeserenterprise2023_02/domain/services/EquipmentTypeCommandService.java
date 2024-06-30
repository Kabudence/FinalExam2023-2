package com.hidalgo.finalexam20232.kaeserenterprise.domain.services;

import com.hidalgo.finalexam20232.kaeserenterprise.domain.model.commands.SeendGroupTypeCommands;

public interface EquipmentTypeCommandService {

    void handle(SeendGroupTypeCommands command);

}
