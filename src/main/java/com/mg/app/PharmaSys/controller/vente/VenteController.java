package com.mg.app.PharmaSys.controller.vente;

import com.mg.app.PharmaSys.model.caracteristique.Administration;
import com.mg.app.PharmaSys.model.caracteristique.Categorie;
import com.mg.app.PharmaSys.model.caracteristique.Maladie;
import com.mg.app.PharmaSys.model.caracteristique.PublicCible;
import com.mg.app.PharmaSys.model.produit.Produit;
import com.mg.app.PharmaSys.model.vente.Vente;
import com.mg.app.PharmaSys.model.vente.VenteDetail;
import com.mg.app.PharmaSys.service.caracteristique.AdministrationService;
import com.mg.app.PharmaSys.service.caracteristique.CategorieService;
import com.mg.app.PharmaSys.service.caracteristique.PublicCibleService;
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
@RequestMapping("/vente")
public class VenteController {
    private final VenteService venteService;
    private final VenteDetailService venteDetailService;
    private final CategorieService categorieService;
    private final PublicCibleService publicCibleService;
    private final AdministrationService administrationService;
    private final ProduitService produitService;


    @GetMapping
    public String listVente(Model model) {
        List<Vente> ventes = venteService.readVente();
        model.addAttribute("ventes", ventes);

        List<Categorie> categorie = categorieService.readCategorie();
        model.addAttribute("categories", categorie);

        List<PublicCible> public_cible = publicCibleService.readPublicCible();
        model.addAttribute("public_cibles", public_cible);

        List<Administration> administration = administrationService.getAllAdministrations();
        model.addAttribute("administrations", administration);
        return "vente/venteListe";
    }

    @GetMapping("/edit")
    public String editVente(@RequestParam(value = "id", required = false) Integer id, Model model) {
        Vente vente = new Vente();
        if (id == null) {

            List<Produit> produit = produitService.readProduits();
            model.addAttribute("produits", produit);

            model.addAttribute("vente", vente);
            return "vente/venteForm";
        }
        vente = venteService.getVenteById(id);
        model.addAttribute("vente", vente);
        return "vente/venteForm";
    }

    @PostMapping("/save")
    public String saveVente(Vente vente) {
        venteService.createVente(vente);
        return "redirect:/vente";
    }

    @GetMapping("/delete")
    public String deleteVente(@RequestParam(value = "id") Integer id) {
        List<VenteDetail> venteDetails = venteDetailService.getVenteDetailByVente(id);
        for (VenteDetail venteDetail : venteDetails) {
            venteDetailService.deleteVenteDetail(venteDetail.getId());
        }
        venteService.deleteVente(id);
        return "redirect:/vente";
    }


    @PostMapping("/recherche")
    public String FiltreProduit(@RequestParam("categorie") Integer id_Categorie,@RequestParam("publicCible") Integer id_PublicCible,@RequestParam("administration") Integer id_administration,Model model) {
        List<Vente> list = venteService.rechercheMulticritere(id_Categorie,id_administration,id_PublicCible);

        model.addAttribute("ventes", list);

        List<Categorie> categorie = categorieService.readCategorie();
        model.addAttribute("categories", categorie);

        List<PublicCible> public_cible = publicCibleService.readPublicCible();
        model.addAttribute("public_cibles", public_cible);

        List<Administration> administration = administrationService.getAllAdministrations();
        model.addAttribute("administrations", administration);
        return "vente/venteListe";

    }



}
