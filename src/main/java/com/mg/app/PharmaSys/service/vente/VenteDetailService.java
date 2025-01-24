package com.mg.app.PharmaSys.service.vente;

import com.mg.app.PharmaSys.model.vente.Vente;
import com.mg.app.PharmaSys.model.vente.VenteDetail;
import com.mg.app.PharmaSys.repository.vente.VenteDetailRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class VenteDetailService {
    private final VenteDetailRepository venteDetailRepository;


    public VenteDetail createVenteDetail(VenteDetail venteDetail) {
        return venteDetailRepository.save(venteDetail);
    }

    public List<VenteDetail> getAllVenteDetail() {
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

    public List<VenteDetail> createMultipleVenteDetail(List<VenteDetail> venteDetails){
        List<VenteDetail> venteDetailsInserer = new ArrayList<>();
        for (VenteDetail venteDetail : venteDetails){
            venteDetailsInserer.add(createVenteDetail(venteDetail));
        }
        return  venteDetailsInserer;
    }

    public List<VenteDetail> rechercheMulticritere(Integer idCategorie, Integer idAdministration, Integer idPublicCible) {
        return venteDetailRepository.rechercheMulticritere(idCategorie, idAdministration, idPublicCible);
    }

}
