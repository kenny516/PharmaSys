package com.mg.app.PharmaSys.service.configuration;

import com.mg.app.PharmaSys.model.configuration.Parametre;
import com.mg.app.PharmaSys.repository.configuration.ParametreRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ParametreService {
    private final ParametreRepository parametreRepository;

    public String getParametreByCle(String cle) {
        return parametreRepository.findById(cle).orElse(null).getValeur();
    }
    // il faut que tous les parametre soit attribue
    public void saveParametre(Parametre parametre) {
        parametreRepository.save(parametre);
    }

    public void updateParametre(Parametre parametre) {
        parametreRepository.save(parametre);
    }

    public void deleteParametre(String cle) {
        parametreRepository.deleteById(cle);
    }


}
