package com.mg.app.PharmaSys.model.vente;

import com.mg.app.PharmaSys.model.caracteristique.Sexe;
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
@Table(name = "vendeur")
public class Vendeur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nom;

    private String prenom;

    @Column(unique = true)
    private String email;

    @ManyToOne
    @JoinColumn(name = "id_sexe")
    private Sexe sexe;


    // Getters et setters
}
