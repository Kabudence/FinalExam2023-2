package com.hidalgo.finalexam20232.kaeserenterprise.interfaces;

import com.hidalgo.finalexam20232.kaeserenterprise.domain.services.MeasurableIndicatorCommandService;
import com.hidalgo.finalexam20232.kaeserenterprise.interfaces.rest.resources.CreateMeasurableResource;
import com.hidalgo.finalexam20232.kaeserenterprise.interfaces.rest.resources.MeasurableIndicatorResource;
import com.hidalgo.finalexam20232.kaeserenterprise.interfaces.rest.transform.CreateMeasurableCommandFromResource;
import com.hidalgo.finalexam20232.kaeserenterprise.interfaces.rest.transform.CreateMeasurableResourceFromEntity;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v3/measurableindicator", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Category", description = "Measurable Indicator Controller")
public class MeasurableIndicatorController {

    private final MeasurableIndicatorCommandService measurableIndicatorCommandService;


    public MeasurableIndicatorController(MeasurableIndicatorCommandService measurableIndicatorCommandService) {
        this.measurableIndicatorCommandService = measurableIndicatorCommandService;
    }

    @PostMapping
    public ResponseEntity<MeasurableIndicatorResource> createMeasurable(@RequestBody CreateMeasurableResource resource){

        var createCommand= CreateMeasurableCommandFromResource.fromResource(resource);
        var measurableIndicatorEntity=measurableIndicatorCommandService.handle(createCommand);
        if(measurableIndicatorEntity.isEmpty()) return ResponseEntity.badRequest().build();
        var measurableResource= CreateMeasurableResourceFromEntity.fromEntity(measurableIndicatorEntity.get());
        return new ResponseEntity<>(measurableResource, org.springframework.http.HttpStatus.CREATED);


    }


}
