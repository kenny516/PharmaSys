package com.mg.app.PharmaSys.controller.vente;

import com.mg.app.PharmaSys.model.medicament.Laboratoire;
import com.mg.app.PharmaSys.model.medicament.Medicament;
import com.mg.app.PharmaSys.model.vente.Vente;
import com.mg.app.PharmaSys.model.vente.VenteDetail;
import com.mg.app.PharmaSys.service.medicament.MedicamentService;
import com.mg.app.PharmaSys.service.vente.VenteDetailService;
import com.mg.app.PharmaSys.service.vente.VenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/vente")
public class VenteController {
    @Autowired
    private VenteService venteService;
    @Autowired
    private VenteDetailService venteDetailService;
    @Autowired
    private MedicamentService medicamentService;

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
        Vente vente = new Vente();
        vente.setId(idVente);
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
    public String saveVenteDetail(VenteDetail venteDetail) {
        if (venteDetail.getId() == null) {
            Medicament medicament = medicamentService.getMedicamentById(venteDetail.getMedicament().getId());
            venteDetail.setPrixUnitaire(medicament.getPrix());
        }
        venteDetailService.createVenteDetail(venteDetail);
        venteService.updateVenteData(venteDetail.getVente().getId());
        return "redirect:/vente/"+venteDetail.getVente().getId()+"/detail";
    }

    @GetMapping("/detail/delete")
    public String deleteVenteDetail(@RequestParam(value = "idVenteDetail") Integer id) {
        VenteDetail venteDetail = venteDetailService.getVenteDetailById(id);
        venteDetailService.deleteVenteDetail(id);
        venteService.updateVenteData(venteDetail.getVente().getId());
        return "redirect:/vente/"+venteDetail.getVente().getId()+"/detail";
    }














}
