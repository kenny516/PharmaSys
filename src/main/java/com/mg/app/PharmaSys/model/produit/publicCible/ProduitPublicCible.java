package com.mg.app.PharmaSys.model.produit.publicCible;


import com.mg.app.PharmaSys.model.produit.Produit;
import com.mg.app.PharmaSys.model.caracteristique.PublicCible;
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
@Table(name = "produit_public_cible")
public class ProduitPublicCible {

    @EmbeddedId
    private ProduitPublicCibleId id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_produit", insertable = false, updatable = false)
    private Produit produit;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_public", insertable = false, updatable = false)
    private PublicCible publicCible;
}
