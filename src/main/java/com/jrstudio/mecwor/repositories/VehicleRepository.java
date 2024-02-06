package com.jrstudio.mecwor.repositories;

import com.jrstudio.mecwor.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    boolean existsById(Long id);
    Optional<Vehicle> findByIdentificationVehicle(String identificationVehicle);
    boolean existsByIdentificationVehicle(String identificationVehicle);

}
