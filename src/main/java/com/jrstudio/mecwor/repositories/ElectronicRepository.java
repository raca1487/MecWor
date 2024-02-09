package com.jrstudio.mecwor.repositories;

import com.jrstudio.mecwor.entities.Electronic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ElectronicRepository extends JpaRepository<Electronic, Long> {

    boolean existsByPowerSupply(String powerSupply);
    Optional<Electronic> findByPowerSupply(String powerSupply);

}
