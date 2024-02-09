package com.jrstudio.mecwor.services;

import com.jrstudio.mecwor.entities.Electronic;
import com.jrstudio.mecwor.repositories.ElectronicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ElectronicService extends ProductService {

    @Autowired
    ElectronicRepository electronicRepository;

    public List<Electronic> electronicList() { return electronicRepository.findAll(); }
    public Optional<Electronic> getOneByPowerSupply(String powerSupply) { return electronicRepository.findByPowerSupply(powerSupply); }
    public boolean existsByPowerSupply(String powerSupply) { return electronicRepository.existsByPowerSupply(powerSupply); }

}
