package com.hidalgo.finalexam20232.kaeserenterprise.infrastructure.jpa.repositories;

import com.hidalgo.finalexam20232.kaeserenterprise.domain.model.aggregates.Equipment;
import com.hidalgo.finalexam20232.kaeserenterprise.domain.model.valueobjects.MaterialSerialNumber;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentRepository extends JpaRepository<Equipment, Long> {

    boolean existsByMaterialSerialNumber(@NotNull MaterialSerialNumber materialSerialNumber);

}
