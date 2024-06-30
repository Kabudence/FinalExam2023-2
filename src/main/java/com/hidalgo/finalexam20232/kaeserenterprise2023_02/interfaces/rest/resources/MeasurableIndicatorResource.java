package com.hidalgo.finalexam20232.kaeserenterprise.interfaces.rest.resources;

public record MeasurableIndicatorResource(Long id,
                                          String symbol,
                                          String description,
                                          Double thresholdMinimum,
                                          Double thresholdMaximum,
                                          String equipmentType) {
}
