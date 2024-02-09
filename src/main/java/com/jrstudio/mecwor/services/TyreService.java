package com.jrstudio.mecwor.services;

import com.jrstudio.mecwor.entities.Tyre;
import com.jrstudio.mecwor.repositories.TyreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TyreService extends ProductService {

    @Autowired
    TyreRepository tyreRepository;

    public List<Tyre> tyreList() {
        return tyreRepository.findAll();
    }
    public Optional<Tyre> getOneBySize(Long size) {
        return tyreRepository.findByDiameter(size);
    }
    public boolean existsBySize(Long size) { return tyreRepository.existsByDiameter(size); }

}
