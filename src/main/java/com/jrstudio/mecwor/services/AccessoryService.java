package com.jrstudio.mecwor.services;

import com.jrstudio.mecwor.entities.Accessory;
import com.jrstudio.mecwor.repositories.AccessoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AccessoryService extends ProductService {

    @Autowired
    AccessoryRepository accessoryRepository;

    public List<Accessory> accessoryList() { return accessoryRepository.findAll(); }
    public Optional<Accessory> getOneBySize(String size) { return accessoryRepository.findBySize(size); }
    public Optional<Accessory> getOneByVoltage(String voltage) { return accessoryRepository.findByVoltage(voltage); }
    public boolean existsBySize(String size) { return accessoryRepository.existsBySize(size); }
    public boolean existsByVoltage(String voltage) { return accessoryRepository.existsByVoltage(voltage); }

}
