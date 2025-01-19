package com.mg.app.PharmaSys.model.vente;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Client")
public class Client{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nom", length = 50)
    @NotNull(message = "Le nom est obligatoire")
    private String nom;

    @Column(name = "prenom", length = 50)
    @NotNull(message = "Le prenom est obligatoire")
    private String prenom;

}