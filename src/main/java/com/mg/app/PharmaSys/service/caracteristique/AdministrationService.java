package com.mg.app.PharmaSys.service.caracteristique;

import com.mg.app.PharmaSys.model.caracteristique.Administration;
import com.mg.app.PharmaSys.repository.caracteristique.AdministrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AdministrationService {

    @Autowired
    private AdministrationRepository administrationRepository;

    public List<Administration> getAllAdministrations() {
        return administrationRepository.findAll();
    }

    public Optional<Administration> getAdministrationById(Integer id) {
        return administrationRepository.findById(id);
    }

    public Administration createAdministration(Administration administration) {
        return administrationRepository.save(administration);
    }

    public Administration updateAdministration(Integer id, Administration administration) {
        if (administrationRepository.existsById(id)) {
            administration.setId(id);
            return administrationRepository.save(administration);
        }
        return null;
    }

    public void deleteAdministration(Integer id) {
        if (administrationRepository.existsById(id)) {
            administrationRepository.deleteById(id);
        }
    }
}
