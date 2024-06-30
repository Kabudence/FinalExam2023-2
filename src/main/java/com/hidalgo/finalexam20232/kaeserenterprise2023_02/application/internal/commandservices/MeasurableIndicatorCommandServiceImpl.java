package com.hidalgo.finalexam20232.kaeserenterprise.application.internal.commandservices;

import com.hidalgo.finalexam20232.kaeserenterprise.domain.model.aggregates.MeasurableIndicator;
import com.hidalgo.finalexam20232.kaeserenterprise.domain.model.commands.CreateMeasurableIndicatorCommand;
import com.hidalgo.finalexam20232.kaeserenterprise.domain.services.MeasurableIndicatorCommandService;
import com.hidalgo.finalexam20232.kaeserenterprise.infrastructure.jpa.repositories.EquipmentTypeRepository;
import com.hidalgo.finalexam20232.kaeserenterprise.infrastructure.jpa.repositories.MeasurableIndicatorRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ValidationException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MeasurableIndicatorCommandServiceImpl  implements MeasurableIndicatorCommandService {

    private final MeasurableIndicatorRepository measurableIndicatorRepository;
    private final EquipmentTypeRepository equipmentTypeRepository;


    public MeasurableIndicatorCommandServiceImpl(MeasurableIndicatorRepository measurableIndicatorRepository, EquipmentTypeRepository equipmentTypeRepository) {
        this.measurableIndicatorRepository = measurableIndicatorRepository;
        this.equipmentTypeRepository = equipmentTypeRepository;
    }

    @Override
    public Optional<MeasurableIndicator> handle(CreateMeasurableIndicatorCommand command) {
        var equipmentType= equipmentTypeRepository.findByName(command.equipmentType());
        if(equipmentType.isEmpty()){
            throw new EntityNotFoundException("EquipmentType with name does not exist");
        }

        validateCommand(command);

        var measurableIndicator=new MeasurableIndicator(command, equipmentType.get());
        measurableIndicatorRepository.save(measurableIndicator);
        return Optional.of(measurableIndicator);
    }

    private void validateCommand(CreateMeasurableIndicatorCommand command) {
        var existsBySymbolAndType = measurableIndicatorRepository.existsBySymbolAndEquipmentTypeName(command.symbol(), command.equipmentType());
        if (existsBySymbolAndType) {
            throw new ValidationException("Already exist MeasurableIndicator with same Symbol and Type");
        }

        if (command.thresholdMinimum() >= command.thresholdMaximum()) {
            throw new ValidationException("ThresholdMinimum must be less than ThresholdMaximum");
        }
    }

}
