package com.mg.app.PharmaSys.model.produit.Maladie;


import com.mg.app.PharmaSys.model.caracteristique.Maladie;
import com.mg.app.PharmaSys.model.produit.Produit;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "produit_maladie")
public class ProduitsMaladie {
    @EmbeddedId
    ProduitsMaladieId id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_produit", insertable = false, updatable = false)
    private Produit produit;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_maladie", insertable = false, updatable = false)
    private Maladie maladie;


}
