package com.jrstudio.mecwor.services;

import com.jrstudio.mecwor.entities.Vehicle;
import com.jrstudio.mecwor.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class VehicleService {

    @Autowired
    VehicleRepository vehicleRepository;

    public List<Vehicle> vehicleList() {
        return vehicleRepository.findAll();
    }
    public Optional<Vehicle> getOne(long id) {
        return vehicleRepository.findById(id);
    }
    public Optional<Vehicle> getByIdentificationVehicle(String identificationVehicle) {
        return vehicleRepository.findByIdentificationVehicle(identificationVehicle);
    }

    public void save(Vehicle vehicle) {
        vehicleRepository.save(vehicle);
    }
    public void delete(long id) {
        vehicleRepository.deleteById(id);
    }
    public boolean existsById(long id) {
        return vehicleRepository.existsById(id);
    }
    public boolean existsByIdentificationVehicle(String identificationVehicle) {
        return vehicleRepository.existsByIdentificationVehicle(identificationVehicle);
    }

}
