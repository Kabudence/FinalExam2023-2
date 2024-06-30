package com.hidalgo.finalexam20232.kaeserenterprise.infrastructure.jpa.repositories;

import com.hidalgo.finalexam20232.kaeserenterprise.domain.model.aggregates.MeasurableIndicator;
import com.hidalgo.finalexam20232.kaeserenterprise.domain.model.valueobjects.EquipmentTypes;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeasurableIndicatorRepository extends JpaRepository<MeasurableIndicator, Long> {

    boolean existsBySymbolAndEquipmentTypeName(@Size(max = 50) @NotBlank String symbol, EquipmentTypes equipmentType_name);
}
