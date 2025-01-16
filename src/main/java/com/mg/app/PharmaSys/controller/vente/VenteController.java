package com.mg.app.PharmaSys.controller.vente;

import com.mg.app.PharmaSys.model.caracteristique.*;
import com.mg.app.PharmaSys.model.produit.Produit;
import com.mg.app.PharmaSys.model.vente.Vente;
import com.mg.app.PharmaSys.model.vente.VenteDetail;
import com.mg.app.PharmaSys.service.caracteristique.AdministrationService;
import com.mg.app.PharmaSys.service.caracteristique.CategorieService;
import com.mg.app.PharmaSys.service.caracteristique.ClientService;
import com.mg.app.PharmaSys.service.caracteristique.PublicCibleService;
import com.mg.app.PharmaSys.service.produit.ProduitService;
import com.mg.app.PharmaSys.service.stock.StockService;
import com.mg.app.PharmaSys.service.vente.VenteDetailService;
import com.mg.app.PharmaSys.service.vente.VenteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/vente")
public class VenteController {
    private final VenteService venteService;
    private final VenteDetailService venteDetailService;
    private final ProduitService produitService;
    private final ClientService clientService;


    @GetMapping
    public String listVente(Model model) {
        List<Vente> ventes = venteService.readVente();
        model.addAttribute("ventes", ventes);
        return "vente/venteListe";
    }

    @GetMapping("/edit")
    public String editVente(@RequestParam(value = "id", required = false) Integer id, Model model) {
        Vente vente = new Vente();
        List<Client> listeClient = clientService.getAll();
        model.addAttribute("listeClient",listeClient);
        if (id == null) {
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
    public String FiltreProduit(Model model) {
        List<Vente> list = venteService.rechercheMulticritere();
        model.addAttribute("ventes", list);
        return "vente/venteListe";

    }

    @PostMapping("/client")
    public String FiltreProduit2(Model model, @RequestParam("date") LocalDate date) {
        List<Vente> listeVente = venteService.rechercheClient(date);
        model.addAttribute("listeVente",listeVente);
        return "caracteristique/Client/ClientList";
    }



}
