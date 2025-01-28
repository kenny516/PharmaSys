package com.mg.app.PharmaSys.controller.vente;

import com.mg.app.PharmaSys.model.caracteristique.Administration;
import com.mg.app.PharmaSys.model.caracteristique.Categorie;
import com.mg.app.PharmaSys.model.caracteristique.PublicCible;
import com.mg.app.PharmaSys.model.produit.Produit;
import com.mg.app.PharmaSys.model.vente.Vente;
import com.mg.app.PharmaSys.model.vente.VenteDetail;
import com.mg.app.PharmaSys.service.caracteristique.AdministrationService;
import com.mg.app.PharmaSys.service.caracteristique.CategorieService;
import com.mg.app.PharmaSys.service.caracteristique.PublicCibleService;
import com.mg.app.PharmaSys.service.produit.HistoriquePrixService;
import com.mg.app.PharmaSys.service.produit.ProduitService;
import com.mg.app.PharmaSys.service.stock.StockService;
import com.mg.app.PharmaSys.service.vente.VenteDetailService;
import com.mg.app.PharmaSys.service.vente.VenteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/venteDetail")
public class VenteDetailController {
    private final VenteService venteService;
    private final VenteDetailService venteDetailService;
    private final ProduitService produitService;
    private final StockService stockService;
    private final CategorieService categorieService;
    private final PublicCibleService publicCibleService;
    private final AdministrationService administrationService;
    private final HistoriquePrixService historiquePrixService;


    @GetMapping("/general")
    public String listVenteDetail(Model model) {
        List<VenteDetail> venteDetails = venteDetailService.getAllVenteDetail();
        model.addAttribute("venteDetails", venteDetails);
        List<Categorie> categorie = categorieService.getAllCategorie();
        model.addAttribute("categories", categorie);
        List<PublicCible> public_cible = publicCibleService.getAllPublicCible();
        model.addAttribute("public_cibles", public_cible);
        List<Administration> administration = administrationService.getAllAdministration();
        model.addAttribute("administrations", administration);

        model.addAttribute("categorieId",null);
        model.addAttribute("publicCibleId",null);
        model.addAttribute("administrationId",null);
        return "vente/venteDetail/venteDetailListeGeneral";
    }

    @PostMapping("/recherche")
    public String FiltreProduit(@RequestParam(value = "categorie", required = false) Integer id_Categorie, @RequestParam(value = "publicCible", required = false) Integer id_PublicCible, @RequestParam(value = "administration", required = false) Integer id_administration, Model model) {
        List<VenteDetail> venteDetails = venteDetailService.rechercheMulticritere(id_Categorie, id_administration, id_PublicCible);
        model.addAttribute("venteDetails", venteDetails);

        List<Categorie> categorie = categorieService.getAllCategorie();
        model.addAttribute("categories", categorie);

        List<PublicCible> public_cible = publicCibleService.getAllPublicCible();
        model.addAttribute("public_cibles", public_cible);

        List<Administration> administration = administrationService.getAllAdministration();
        model.addAttribute("administrations", administration);

        model.addAttribute("categorieId",id_Categorie);
        model.addAttribute("publicCibleId",id_PublicCible);
        model.addAttribute("administrationId",id_administration);
        return "vente/venteDetail/venteDetailListeGeneral";
    }
    // vente detail relier avec vente

    @GetMapping("")
    public String listVenteDetail(@RequestParam(value = "idVente") Integer idVente, Model model) {
        Vente vente = venteService.getVenteById(idVente);
        List<VenteDetail> venteDetails = venteDetailService.getVenteDetailByVente(idVente);
        model.addAttribute("vente", vente);
        model.addAttribute("venteDetails", venteDetails);
        return "vente/venteDetail/venteDetailListe";
    }

    @GetMapping("/edit")
    public String editVenteDetail(@RequestParam(value = "idVenteDetail", required = false) Integer idVenteDetail, @RequestParam(value = "idVente", required = false) Integer idVente, Model model) {
        List<Produit> produits = produitService.getAllProduits();
        model.addAttribute("produits", produits);
        VenteDetail venteDetail = new VenteDetail();
        Vente vente = venteService.getVenteById(idVente);
        venteDetail.setVente(vente);
        if (idVenteDetail == null) {
            model.addAttribute("venteDetail", venteDetail);
            return "vente/venteDetail/venteDetailForm";
        }
        venteDetail = venteDetailService.getVenteDetailById(idVenteDetail);
        model.addAttribute("venteDetail", venteDetail);
        return "vente/venteDetail/venteDetailForm";
    }

    @PostMapping("/save")
    public String saveVenteDetail(VenteDetail venteDetail, Model model) {
        Double quantiteInitial = 0.0;
        Vente currentVente = venteService.getVenteById(venteDetail.getVente().getId());
        LocalDate date = LocalDate.from(currentVente.getDateVente());
        if (venteDetail.getId() == null) {
            Produit produit = produitService.getProduitById(venteDetail.getProduit().getId());
            venteDetail.setPrixUnitaire(produit.getPrix());
        } else {
            VenteDetail venteDetailOld = venteDetailService.getVenteDetailById(venteDetail.getId());
            quantiteInitial = venteDetailOld.getQuantite();
        }
        try {
            List<VenteDetail> venteDetailsGenere = stockService.processVenteDetails(venteDetail, quantiteInitial);
            Double prixUnitaire = historiquePrixService.getPrixCurrent(venteDetail.getProduit().getId(),date);
            for (VenteDetail detail : venteDetailsGenere) {
                detail.setPrixUnitaire(prixUnitaire);
            }
            venteDetailService.createMultipleVenteDetail(venteDetailsGenere);
            venteService.updateVenteData(venteDetail.getVente().getId());
        } catch (IllegalArgumentException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "error/Error";
        }
        return "redirect:/venteDetail?idVente=" + venteDetail.getVente().getId();
    }

    @GetMapping("/delete")
    public String deleteVenteDetail(@RequestParam(value = "idVenteDetail") Integer id) {
        VenteDetail venteDetail = venteDetailService.getVenteDetailById(id);
        venteDetail.setQuantite(venteDetail.getQuantite() * -1);
        venteDetailService.deleteVenteDetail(id);
        stockService.processVenteDetails(venteDetail, 0.0);
        venteService.updateVenteData(venteDetail.getVente().getId());
        return "redirect:/venteDetail?idVente=" + venteDetail.getVente().getId();
    }

}
