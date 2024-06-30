package com.hidalgo.finalexam20232.isaenterprise2023_1.domain.model.aggregates;

import com.hidalgo.finalexam20232.isaenterprise2023_1.domain.model.entities.LeakageType;
import com.hidalgo.finalexam20232.isaenterprise2023_1.domain.model.valueobjects.LeakageTypes;
import com.hidalgo.finalexam20232.isaenterprise2023_1.domain.model.valueobjects.ProductSerialNumber;
import com.hidalgo.finalexam20232.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Entity
public class Snapshots extends AuditableAbstractAggregateRoot<Snapshots> {

    @Getter
    @Size(max = 50)
    @NotBlank
    private String snapshotId;

    @NotNull
    @Embedded
    private ProductSerialNumber productSerialNumber;


    @Getter
    @Min(0)
    private Double Temperature;

    @Getter
    @Min(0)
    private Double energy;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "leakage_type_id")
    private LeakageType leakageType;


    private Double temperature;

    public String getLeakageType() {
        return leakageType.getName().toString();
    }



}
