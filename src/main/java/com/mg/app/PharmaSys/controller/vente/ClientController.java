package com.mg.app.PharmaSys.controller.vente;

import com.mg.app.PharmaSys.model.vente.Client;
import com.mg.app.PharmaSys.service.vente.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@Controller
@RequestMapping("/client")
public class ClientController {

    private final ClientService clientService;

    @GetMapping
    public String liste(Model model) {
        model.addAttribute("listeClient", clientService.getAllClient());
        return "vente/client/clientListe";
    }

    @GetMapping("/new")
    public String form(Model model) {
        model.addAttribute("client", new Client());
        return "vente/client/clientForm";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam(value = "id") Integer id, Model model) {
        model.addAttribute("client", clientService.findById(id));
        return "vente/client/clientForm";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Client client) {
        clientService.createClient(client);
        return "redirect:/client";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam(value = "id")  Integer id) {
        clientService.deleteClientById(id);
        return "redirect:/client";
    }
}
