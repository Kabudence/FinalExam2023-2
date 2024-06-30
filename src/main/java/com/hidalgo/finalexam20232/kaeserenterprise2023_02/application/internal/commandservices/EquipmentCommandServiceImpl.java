package com.hidalgo.finalexam20232.kaeserenterprise.application.internal.commandservices;

import com.hidalgo.finalexam20232.kaeserenterprise.domain.model.aggregates.Equipment;
import com.hidalgo.finalexam20232.kaeserenterprise.domain.model.commands.CreateEquipmentCommand;
import com.hidalgo.finalexam20232.kaeserenterprise.domain.services.EquipmentCommandService;
import com.hidalgo.finalexam20232.kaeserenterprise.infrastructure.jpa.repositories.EquipmentRepository;
import com.hidalgo.finalexam20232.kaeserenterprise.infrastructure.jpa.repositories.EquipmentTypeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EquipmentCommandServiceImpl implements EquipmentCommandService {

    private final EquipmentRepository equipmentRepository;
    private final EquipmentTypeRepository equipmentTypeRepository;

    public EquipmentCommandServiceImpl(EquipmentRepository equipmentRepository, EquipmentTypeRepository equipmentTypeRepository) {
        this.equipmentRepository = equipmentRepository;
        this.equipmentTypeRepository = equipmentTypeRepository;
    }


    @Override
    public Optional<Equipment> handle(CreateEquipmentCommand command) {

        var equipmentType= equipmentTypeRepository.findByName(command.equipmentType());
        if(equipmentType.isEmpty()){
            throw new RuntimeException("EquipmentType with name does not exist");
        }

        var equipment = new Equipment(command,equipmentType.get());
        return Optional.of( equipmentRepository.save(equipment));

    }
}
