package com.mg.app.PharmaSys.service.caracteristique;

import com.mg.app.PharmaSys.model.caracteristique.Categorie;
import com.mg.app.PharmaSys.model.caracteristique.Client;
import com.mg.app.PharmaSys.repository.caracteristique.CategorieRepository;
import com.mg.app.PharmaSys.repository.caracteristique.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class ClientService {
    private final ClientRepository clientRepository;

    public List<Client> getAll(){
        return clientRepository.findAll();
    }
}
