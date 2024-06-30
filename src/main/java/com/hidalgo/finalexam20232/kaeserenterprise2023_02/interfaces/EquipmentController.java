package com.hidalgo.finalexam20232.kaeserenterprise.interfaces;

import com.hidalgo.finalexam20232.kaeserenterprise.domain.services.EquipmentCommandService;
import com.hidalgo.finalexam20232.kaeserenterprise.interfaces.rest.resources.CreateEquipmentResource;
import com.hidalgo.finalexam20232.kaeserenterprise.interfaces.rest.resources.EquipmentResource;
import com.hidalgo.finalexam20232.kaeserenterprise.interfaces.rest.transform.CreateEquipmentCommandFromResourceAssembler;
import com.hidalgo.finalexam20232.kaeserenterprise.interfaces.rest.transform.CreateEquipmentResourceFromEntityAseembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v3/equipment", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Category", description = "Equipment Controller")
public class EquipmentController {

    private final EquipmentCommandService equipmentCommandService;


    public EquipmentController(EquipmentCommandService equipmentCommandService) {
        this.equipmentCommandService = equipmentCommandService;
    }

    @PostMapping
    public ResponseEntity<EquipmentResource>createEquipment(@RequestBody CreateEquipmentResource resource){

        var createEquipmentCommand= CreateEquipmentCommandFromResourceAssembler.toCommandFromResource(resource);
        var equipmentEntity=equipmentCommandService.handle(createEquipmentCommand);
        if(equipmentEntity.isEmpty()) return ResponseEntity.badRequest().build();
        var equipmentResource= CreateEquipmentResourceFromEntityAseembler.createResourceFromEntity(equipmentEntity.get());
        return new ResponseEntity<>(equipmentResource, HttpStatus.CREATED);

    }

}
