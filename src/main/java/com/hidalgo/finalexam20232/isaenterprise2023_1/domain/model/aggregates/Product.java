package com.hidalgo.finalexam20232.isaenterprise2023_1.domain.model.aggregates;

import com.hidalgo.finalexam20232.isaenterprise2023_1.domain.model.entities.MonitoringLevel;
import com.hidalgo.finalexam20232.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Entity
public class Products extends AuditableAbstractAggregateRoot<Products> {

    @Getter
    @Size(max = 50)
    @NotBlank
    private String brand;

    @Getter
    @Size(max = 50)
    @NotBlank
    private  String model;

    @Getter
    @Size(max = 50)
    @NotBlank
    private String serialNumber;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "monitoring_level_id")
    private MonitoringLevel monitoringLevel;

    public String getMonitoringLevel() {
        return monitoringLevel.getName().toString();
    }


}
