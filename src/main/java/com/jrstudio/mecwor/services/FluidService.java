package com.jrstudio.mecwor.services;

import com.jrstudio.mecwor.entities.Fluid;
import com.jrstudio.mecwor.repositories.FluidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FluidService extends ProductService {

    @Autowired
    FluidRepository fluidRepository;

    public List<Fluid> fluidList() { return fluidRepository.findAll(); }
    public Optional<Fluid> getOneByQuantityFluid(String quantityFluid) { return fluidRepository.findByQuantityFluid(quantityFluid); }
    public boolean existsByQuantityFluid(String quantityFluid) { return fluidRepository.existsByQuantityFluid(quantityFluid); }

}
