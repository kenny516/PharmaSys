package com.mg.app.PharmaSys.model.produit;

import com.mg.app.PharmaSys.model.caracteristique.Administration;
import com.mg.app.PharmaSys.model.caracteristique.Categorie;
import com.mg.app.PharmaSys.model.caracteristique.Unite;
import jakarta.persistence.*;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "produit")
public class Produit {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nom", length = 50)
    private String nom;

    @Column(name = "description")
    private String description;

    @Column(name = "prix")
    @PositiveOrZero(message = "Le prix ne peut pas être négatif")
    private Double prix;

    @Column(name = "perissable")
    private Boolean perissable;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_unite")
    private Unite unite;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_categorie")
    private Categorie categorie;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_laboratoire")
    private com.mg.app.PharmaSys.model.caracteristique.Laboratoire Laboratoire;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_administration")
    private Administration administration;
}