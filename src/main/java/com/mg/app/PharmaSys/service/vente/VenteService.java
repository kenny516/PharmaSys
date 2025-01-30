package com.mg.app.PharmaSys.service.vente;

import com.mg.app.PharmaSys.DTO.CommissionDTO;
import com.mg.app.PharmaSys.model.vente.Vente;
import com.mg.app.PharmaSys.model.vente.VenteDetail;
import com.mg.app.PharmaSys.repository.vente.VenteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Service
public class VenteService {
    private final VenteRepository venteRepository;
    private final VenteDetailService venteDetailService;

    public Vente createVente(Vente vente) {
        return venteRepository.save(vente);
    }

    public List<Vente> getAllVente() {
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

    public List<Vente> rechercheMulticritere() {
        return venteRepository.rechercheMulticritere();
    }

    public List<Vente> rechercheClient(LocalDate date) {
        return venteRepository.rechercheClient(date);
    }

    public List<CommissionDTO> getCommissionVendeurByIntervalleDateAndSexe(LocalDate startDate, LocalDate endDate, Integer id_sexe) {
        return venteRepository.filtreCommissionVendeurByIntervalleDateAndSexe(startDate, endDate, id_sexe);
    }
}
