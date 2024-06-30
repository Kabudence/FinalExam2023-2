package com.hidalgo.finalexam20232.kaeserenterprise.interfaces.rest.transform;


import com.hidalgo.finalexam20232.kaeserenterprise.domain.model.commands.CreateEquipmentCommand;
import com.hidalgo.finalexam20232.kaeserenterprise.domain.model.valueobjects.EquipmentTypes;
import com.hidalgo.finalexam20232.kaeserenterprise.interfaces.rest.resources.CreateEquipmentResource;

public class CreateEquipmentCommandFromResourceAssembler {

    public static CreateEquipmentCommand toCommandFromResource(CreateEquipmentResource resource){
        EquipmentTypes equipmentType = EquipmentTypes.valueOf(resource.equipmentType().toUpperCase());

        return new CreateEquipmentCommand( resource.model(),equipmentType);




    }
}
