package com.hidalgo.finalexam20232.kaeserenterprise.interfaces.rest.transform;

import com.hidalgo.finalexam20232.kaeserenterprise.domain.model.aggregates.Equipment;
import com.hidalgo.finalexam20232.kaeserenterprise.interfaces.rest.resources.EquipmentResource;

public class CreateEquipmentResourceFromEntityAseembler {
    public static EquipmentResource createResourceFromEntity(Equipment entity){
        return new EquipmentResource(entity.getId(),
                entity.getMaterialSerialNumberString(),
                entity.getModel(),
                entity.getEquipmentType());

    }
}
