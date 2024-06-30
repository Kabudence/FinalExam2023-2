package com.hidalgo.finalexam20232.kaeserenterprise.infrastructure.jpa.repositories;

import com.hidalgo.finalexam20232.kaeserenterprise.domain.model.entities.EquipmentType;
import com.hidalgo.finalexam20232.kaeserenterprise.domain.model.valueobjects.EquipmentTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EquipmentTypeRepository extends JpaRepository<EquipmentType, Long> {

    boolean existsByName(EquipmentTypes name);
    Optional<EquipmentType> findByName(EquipmentTypes name);
}
