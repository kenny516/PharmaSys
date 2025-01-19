package com.mg.app.PharmaSys.service.vente;

import com.mg.app.PharmaSys.model.vente.Client;
import com.mg.app.PharmaSys.repository.vente.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ClientService {
    private final ClientRepository clientRepository;

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    public Client findById(Integer id) {
        Optional<Client> client = clientRepository.findById(id);
        if (client.isPresent()) {
            return client.get();
        } else {
            throw new RuntimeException("Client non trouvé avec l'id: " + id);
        }
    }

    public Client save(Client client) {
        return clientRepository.save(client);
    }

    public void deleteById(Integer id) {
        if (clientRepository.existsById(id)) {
            clientRepository.deleteById(id);
        } else {
            throw new RuntimeException("Client non trouvé avec l'id: " + id);
        }
    }

    // Méthode utilitaire pour vérifier si un client existe
    public boolean existsById(Integer id) {
        return clientRepository.existsById(id);
    }
}
