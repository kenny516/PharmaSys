package com.mg.app.PharmaSys.controller.caracteristique;

import com.mg.app.PharmaSys.model.caracteristique.Categorie;
import com.mg.app.PharmaSys.service.caracteristique.CategorieService;
import com.mg.app.PharmaSys.service.vente.VenteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

    @AllArgsConstructor
    @Controller
    @RequestMapping("/caracteristique/client")
    public class ClientController {

        private final VenteService venteService;

    }
