package com.mg.app.PharmaSys.service.vente;

import com.mg.app.PharmaSys.model.vente.Vente;
import com.mg.app.PharmaSys.model.vente.VenteDetail;
import com.mg.app.PharmaSys.repository.vente.VenteDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VenteDetailService {
    private final VenteDetailRepository venteDetailRepository;

    @Autowired
    public VenteDetailService(VenteDetailRepository venteDetailRepository) {
        this.venteDetailRepository = venteDetailRepository;
    }

    public VenteDetail createVenteDetail(VenteDetail venteDetail) {
        return venteDetailRepository.save(venteDetail);
    }

    public List<VenteDetail> readVenteDetail() {
        return venteDetailRepository.findAll();
    }

    public VenteDetail updateVenteDetail(VenteDetail venteDetail) {
        return venteDetailRepository.save(venteDetail);
    }

    public void deleteVenteDetail(Integer id) {
        venteDetailRepository.deleteById(id);
    }

    ///
    public VenteDetail getVenteDetailById(Integer id) {
        return venteDetailRepository.findById(id).orElse(null);
    }

    public List<VenteDetail> getVenteDetailByVente(Integer id) {
        Vente vente = new Vente();
        vente.setId(id);
        return venteDetailRepository.findVenteDetailByVente(vente);
    }

}
