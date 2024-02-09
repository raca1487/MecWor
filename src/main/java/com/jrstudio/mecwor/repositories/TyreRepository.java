package com.jrstudio.mecwor.repositories;

import com.jrstudio.mecwor.entities.Tyre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TyreRepository extends JpaRepository<Tyre, Long> {

    boolean existsByDiameter(Long diameter);
    Optional<Tyre> findByDiameter(Long diameter);

}
