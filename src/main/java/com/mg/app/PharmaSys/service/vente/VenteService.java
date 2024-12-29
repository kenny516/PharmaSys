package com.mg.app.PharmaSys.service.vente;

import com.mg.app.PharmaSys.model.vente.Vente;
import com.mg.app.PharmaSys.repository.vente.VenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VenteService {
    private final VenteRepository venteRepository;

    @Autowired
    public VenteService(VenteRepository venteRepository) {
        this.venteRepository = venteRepository;
    }

    public Vente createVente(Vente vente) {
        return venteRepository.save(vente);
    }
    public List<Vente> readVente() {
        return venteRepository.findAll();
    }
    public Vente updateVente(Vente vente) {
        return venteRepository.save(vente);
    }
    public void deleteVente(Integer id) {
        venteRepository.deleteById(id);
    }

}
