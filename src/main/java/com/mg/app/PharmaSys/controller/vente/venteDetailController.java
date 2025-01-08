package com.mg.app.PharmaSys.controller.vente;

import com.mg.app.PharmaSys.model.produit.Produit;
import com.mg.app.PharmaSys.model.vente.Vente;
import com.mg.app.PharmaSys.model.vente.VenteDetail;
import com.mg.app.PharmaSys.service.produit.ProduitService;
import com.mg.app.PharmaSys.service.stock.StockService;
import com.mg.app.PharmaSys.service.vente.VenteDetailService;
import com.mg.app.PharmaSys.service.vente.VenteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/venteDetail")
public class venteDetailController {
    private final VenteService venteService;
    private final VenteDetailService venteDetailService;
    private final ProduitService produitService;
    private final StockService stockService;

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
        List<Produit> produits = produitService.readProduits();
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
        if (venteDetail.getId() == null) {
            Produit produit = produitService.getProduitById(venteDetail.getProduit().getId());
            venteDetail.setPrixUnitaire(produit.getPrix());
        } else {
            VenteDetail venteDetailOld = venteDetailService.getVenteDetailById(venteDetail.getId());
            quantiteInitial = venteDetailOld.getQuantite();
        }
        try {
            List<VenteDetail> venteDetailsGenere =  stockService.processVenteDetails(venteDetail,quantiteInitial);
            venteDetailService.createMultipleVenteDetail(venteDetailsGenere);
            venteService.updateVenteData(venteDetail.getVente().getId());
        } catch (IllegalArgumentException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "ErrorPage/Error";
        }
        return "redirect:/vente/" + venteDetail.getVente().getId() + "/detail";
    }

    @GetMapping("/delete")
    public String deleteVenteDetail(@RequestParam(value = "idVenteDetail") Integer id) {
        VenteDetail venteDetail = venteDetailService.getVenteDetailById(id);
        venteDetail.setQuantite(venteDetail.getQuantite() * -1);
        venteDetailService.deleteVenteDetail(id);
        stockService.processVenteDetails(venteDetail,0.0);
        venteService.updateVenteData(venteDetail.getVente().getId());
        return "redirect:/vente/" + venteDetail.getVente().getId() + "/detail";
    }

}
