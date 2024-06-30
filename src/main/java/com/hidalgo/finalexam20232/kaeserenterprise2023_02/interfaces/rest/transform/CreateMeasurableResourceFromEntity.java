package com.hidalgo.finalexam20232.kaeserenterprise.interfaces.rest.transform;

import com.hidalgo.finalexam20232.kaeserenterprise.domain.model.aggregates.MeasurableIndicator;
import com.hidalgo.finalexam20232.kaeserenterprise.interfaces.rest.resources.MeasurableIndicatorResource;

public class CreateMeasurableResourceFromEntity {

    public static MeasurableIndicatorResource fromEntity(MeasurableIndicator measurableIndicator) {
        return new MeasurableIndicatorResource(measurableIndicator.getId(),
                                                measurableIndicator.getSymbol(),
                                                measurableIndicator.getDescription(),
                                                measurableIndicator.getThresholdMinimum(),
                                                measurableIndicator.getThresholdMaximum(),
                                                measurableIndicator.getEquipmentType());
    }

}
