package com.mg.app.PharmaSys.service.produit;

import com.mg.app.PharmaSys.model.produit.Categorie;
import com.mg.app.PharmaSys.repository.produit.CategorieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CategorieService {
    private final CategorieRepository categorieRepository;

    public Categorie createCategorie(Categorie categorie){
        return categorieRepository.save(categorie);
    }

    public List<Categorie> readCategorie(){
        return categorieRepository.findAll();
    }

    public Categorie updateCategorie(Categorie categorie){
        return categorieRepository.save(categorie);
    }

    public void deleteCategorie(Integer id){
        categorieRepository.deleteById(id);
    }

    public Categorie categorieById(Integer id){
        return categorieRepository.findById(id).orElse(null);
    }


}
