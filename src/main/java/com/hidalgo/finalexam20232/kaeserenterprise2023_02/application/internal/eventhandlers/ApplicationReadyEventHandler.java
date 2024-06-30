package com.hidalgo.finalexam20232.kaeserenterprise.application.internal.eventhandlers;

import com.hidalgo.finalexam20232.kaeserenterprise.domain.model.commands.SeendGroupTypeCommands;
import com.hidalgo.finalexam20232.kaeserenterprise.domain.services.EquipmentTypeCommandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class ApplicationReadyEventHandler {
    private final EquipmentTypeCommandService equipmentTypeCommandService;
    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationReadyEventHandler.class);

    public ApplicationReadyEventHandler(EquipmentTypeCommandService equipmentTypeCommandService) {
        this.equipmentTypeCommandService = equipmentTypeCommandService;
    }

    @EventListener
    public void on(ApplicationReadyEvent event){
        var applicationName= event.getApplicationContext().getApplicationName();
        LOGGER.info("Application {} is ready, starting to verify if group types seeding is needed.", applicationName);
        var seedCommand = new SeendGroupTypeCommands();
        equipmentTypeCommandService.handle(seedCommand);
        LOGGER.info("Equipment types seeding is done");

    }

}
