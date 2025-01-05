package com.mg.app.PharmaSys.controller.vente;
import com.mg.app.PharmaSys.model.medicament.Medicament;
import com.mg.app.PharmaSys.model.vente.Vente;
import com.mg.app.PharmaSys.model.vente.VenteDetail;
import com.mg.app.PharmaSys.service.medicament.MedicamentService;
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
    private  VenteService venteService;
    private  VenteDetailService venteDetailService;
    private  MedicamentService medicamentService;
    private  StockService stockService;

    @GetMapping
    public String listVente(Model model) {
        List<Vente> ventes = venteService.readVente();
        model.addAttribute("ventes",ventes);
        return "vente/VenteListe";
    }

    @GetMapping("/edit")
    public String editVente(@RequestParam(value = "id",required = false) Integer id, Model model) {
        Vente vente= new Vente();
        if (id == null) {
            model.addAttribute("vente", vente);
            return "vente/VenteForm";
        }
        vente = venteService.getVenteById(id);
        model.addAttribute("vente", vente);
        return "vente/VenteForm";
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
    ///  vente details

    @GetMapping("/{idVente}/detail")
    public String listVenteDetail(@PathVariable Integer idVente, Model model) {
        Vente vente = venteService.getVenteById(idVente);
        List< VenteDetail> venteDetails = venteDetailService.getVenteDetailByVente(idVente);
        model.addAttribute("vente",vente);
        model.addAttribute("venteDetails",venteDetails);
        return "vente/VenteDetailListe";
    }

    @GetMapping("/detail/edit")
    public String editVenteDetail(@RequestParam(value = "idVenteDetail",required = false) Integer id,@RequestParam(value = "idVente",required = false) Integer idVente, Model model) {
        List<Medicament> medicaments = medicamentService.readMedicaments();
        model.addAttribute("medicaments",medicaments);
        VenteDetail venteDetail= new VenteDetail();
        Vente vente = venteService.getVenteById(idVente);
        venteDetail.setVente(vente);
        if (id == null) {
            model.addAttribute("venteDetail", venteDetail);
            return "vente/VenteDetailForm";
        }
        venteDetail = venteDetailService.getVenteDetailById(id);
        model.addAttribute("venteDetail", venteDetail);
        return "vente/VenteDetailForm";
    }
    @PostMapping("/detail/save")
    public String saveVenteDetail(VenteDetail venteDetail,Model model) {
        Double quantiteInitial = 0.0;
        if (venteDetail.getId() == null) {
            Medicament medicament = medicamentService.getMedicamentById(venteDetail.getMedicament().getId());
            venteDetail.setPrixUnitaire(medicament.getPrix());
        }else {
            VenteDetail venteDetail1 = venteDetailService.getVenteDetailById(venteDetail.getId());
            quantiteInitial = venteDetail1.getQuantite();
        }
        try {
            venteDetail.setQuantite(venteDetail.getQuantite()-quantiteInitial);
            stockService.updateStockForSale(venteDetail);
            venteDetail.setQuantite(venteDetail.getQuantite()+quantiteInitial);
        } catch (IllegalArgumentException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "ErrorPage/Error";
        }
        venteDetailService.createVenteDetail(venteDetail);
        venteService.updateVenteData(venteDetail.getVente().getId());
        return "redirect:/vente/"+venteDetail.getVente().getId()+"/detail";
    }

    @GetMapping("/detail/delete")
    public String deleteVenteDetail(@RequestParam(value = "idVenteDetail") Integer id) {
        VenteDetail venteDetail = venteDetailService.getVenteDetailById(id);
        venteDetail.setQuantite(venteDetail.getQuantite()*-1);
        venteDetailService.deleteVenteDetail(id);
        stockService.updateStockForSale(venteDetail);
        venteService.updateVenteData(venteDetail.getVente().getId());
        return "redirect:/vente/"+venteDetail.getVente().getId()+"/detail";
    }














}
