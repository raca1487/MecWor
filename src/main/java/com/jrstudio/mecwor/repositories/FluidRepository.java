package com.jrstudio.mecwor.repositories;

import com.jrstudio.mecwor.entities.Fluid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FluidRepository extends JpaRepository<Fluid, Long> {

    boolean existsByQuantityFluid(String quantityFluid);
    Optional<Fluid> findByQuantityFluid(String quantityFluid);

}
