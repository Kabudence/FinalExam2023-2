package com.hidalgo.finalexam20232.kaeserenterprise.interfaces.rest.transform;

import com.hidalgo.finalexam20232.kaeserenterprise.domain.model.commands.CreateMeasurableIndicatorCommand;
import com.hidalgo.finalexam20232.kaeserenterprise.domain.model.valueobjects.EquipmentTypes;
import com.hidalgo.finalexam20232.kaeserenterprise.interfaces.rest.resources.CreateMeasurableResource;

public class CreateMeasurableCommandFromResource {

    public static CreateMeasurableIndicatorCommand fromResource(CreateMeasurableResource resource) {
        EquipmentTypes equipmentType = EquipmentTypes.valueOf(resource.equipmentType().toUpperCase());
        return new CreateMeasurableIndicatorCommand(resource.symbol(),
                                                        resource.description(),
                                                        resource.thresholdMinimum(),
                                                        resource.thresholdMaximum(),
                                                         equipmentType);
    }
}
