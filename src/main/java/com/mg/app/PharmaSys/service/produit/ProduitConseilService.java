package com.mg.app.PharmaSys.service.produit;

import com.mg.app.PharmaSys.model.produit.ProduitConseil;
import com.mg.app.PharmaSys.repository.produit.ProduitConseilRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ProduitConseilService {

    private final ProduitConseilRepository produitConseilRepository;

    public ProduitConseil saveProduitConseil(ProduitConseil produitConseil) {
        return produitConseilRepository.save(produitConseil);
    }

    public ProduitConseil getProduitConseilById(Integer id) {
        return produitConseilRepository.findById(id).orElse(null);
    }

    public List<ProduitConseil> getAllProduitConseils() {
        return produitConseilRepository.findAll();
    }

    public void deleteProduitConseilById(Integer id) {
        produitConseilRepository.deleteById(id);
    }

    public List<ProduitConseil> recherche(LocalDate date) {
        LocalDate debutMois = date.withDayOfMonth(1);
        LocalDate finMois = date.withDayOfMonth(date.lengthOfMonth());
        return produitConseilRepository.getProduitConseil(debutMois, finMois);
    }
    public List<ProduitConseil> rechercheF(LocalDate date) {
        return produitConseilRepository.getProduitConseil(date);
    }

}

