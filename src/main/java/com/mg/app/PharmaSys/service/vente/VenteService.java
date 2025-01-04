package com.mg.app.PharmaSys.service.vente;

import com.mg.app.PharmaSys.model.vente.Vente;
import com.mg.app.PharmaSys.model.vente.VenteDetail;
import com.mg.app.PharmaSys.repository.vente.VenteDetailRepository;
import com.mg.app.PharmaSys.repository.vente.VenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VenteService {
    private final VenteRepository venteRepository;
    private final VenteDetailService venteDetailService;

    @Autowired
    public VenteService(VenteRepository venteRepository, VenteDetailService venteDetailService) {
        this.venteRepository = venteRepository;
        this.venteDetailService = venteDetailService;
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

    ///
    public Vente getVenteById(Integer id) {
        return venteRepository.findById(id).orElse(null);

    }

    public Vente updateVenteData(Integer idVente) {
        Vente vente = getVenteById(idVente);
        List<VenteDetail> venteDetails = venteDetailService.getVenteDetailByVente(idVente);
        double montantTotal = 0.0;
        for (VenteDetail venteDetail : venteDetails) {
            montantTotal += venteDetail.getPrixUnitaire() * venteDetail.getQuantite();
        }
        vente.setMontantTotal(montantTotal);
        return updateVente(vente);
    }
}
