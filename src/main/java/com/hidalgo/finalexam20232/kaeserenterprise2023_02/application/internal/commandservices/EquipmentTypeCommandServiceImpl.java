package com.hidalgo.finalexam20232.kaeserenterprise.application.internal.commandservices;

import com.hidalgo.finalexam20232.kaeserenterprise.domain.model.commands.SeendGroupTypeCommands;
import com.hidalgo.finalexam20232.kaeserenterprise.domain.model.entities.EquipmentType;
import com.hidalgo.finalexam20232.kaeserenterprise.domain.model.valueobjects.EquipmentTypes;
import com.hidalgo.finalexam20232.kaeserenterprise.domain.services.EquipmentTypeCommandService;
import com.hidalgo.finalexam20232.kaeserenterprise.infrastructure.jpa.repositories.EquipmentTypeRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class EquipmentTypeCommandServiceImpl implements EquipmentTypeCommandService {

    private final EquipmentTypeRepository equipmentTypeRepository;

    public EquipmentTypeCommandServiceImpl(EquipmentTypeRepository equipmentTypeRepository) {
        this.equipmentTypeRepository = equipmentTypeRepository;
    }

    @Override
    public void handle(SeendGroupTypeCommands command) {
        Arrays.stream(EquipmentTypes.values()).forEach(name -> {
            if (!equipmentTypeRepository.existsByName(name)) {
                equipmentTypeRepository.save(new EquipmentType(name));
            }
        });
    }
}
