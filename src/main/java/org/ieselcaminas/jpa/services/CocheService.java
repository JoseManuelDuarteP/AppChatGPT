package org.ieselcaminas.jpa.services;

import org.ieselcaminas.jpa.entity.Coche;
import org.ieselcaminas.jpa.repository.CocheRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CocheService {
    private final CocheRepository cocheRepository;

    public CocheService(CocheRepository cocheRepository) {
        this.cocheRepository = cocheRepository;
    }

    public List<Coche> getAllCoches() {
        return cocheRepository.findAll();
    }
    
    public Coche saveCoche(Coche coche) {
        return cocheRepository.save(coche);
    }
    
    public void deleteCoche(Long id) {
        cocheRepository.deleteById(id);
    }
}