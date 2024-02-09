package com.jrstudio.mecwor.repositories;

import com.jrstudio.mecwor.entities.Accessory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccessoryRepository extends JpaRepository<Accessory, Long> {

    boolean existsBySize(String size);
    Optional<Accessory> findBySize(String size);
    boolean existsByVoltage(String voltage);
    Optional<Accessory> findByVoltage(String voltage);

}
