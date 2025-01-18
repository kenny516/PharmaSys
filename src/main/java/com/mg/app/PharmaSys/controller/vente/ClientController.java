package com.mg.app.PharmaSys.controller.vente;


import com.mg.app.PharmaSys.service.vente.VenteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@AllArgsConstructor
@Controller
@RequestMapping("/caracteristique/client")
public class ClientController {

    private final VenteService venteService;

}
