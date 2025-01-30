package com.mg.app.PharmaSys.model.produit.Maladie;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Embeddable
public class ProduitMaladieId {

    @Column(name = "id_produit")
    private Integer idProduit;
    @Column(name = "id_maladie")
    private Integer idMaladie;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // Vérifie si c'est le même objet en mémoire
        if (o == null || getClass() != o.getClass()) return false; // Vérifie si l'objet est du même type
        ProduitMaladieId that = (ProduitMaladieId) o; // Cast de l'objet comparé
        return idProduit.equals(that.idProduit) && idMaladie.equals(that.idMaladie); // Comparaison des valeurs
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProduit,idMaladie);
    }


}
