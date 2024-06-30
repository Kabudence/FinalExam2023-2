package com.hidalgo.finalexam20232.kaeserenterprise.domain.services;


import com.hidalgo.finalexam20232.kaeserenterprise.domain.model.aggregates.MeasurableIndicator;
import com.hidalgo.finalexam20232.kaeserenterprise.domain.model.commands.CreateMeasurableIndicatorCommand;

import java.util.Optional;

public interface MeasurableIndicatorCommandService {

    Optional<MeasurableIndicator>handle(CreateMeasurableIndicatorCommand command);

}
