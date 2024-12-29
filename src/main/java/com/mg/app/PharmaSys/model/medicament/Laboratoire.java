package com.mg.app.PharmaSys.model.medicament;

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
@Table(name = "laboratoire")
public class Laboratoire {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nom", length = 50)
    @NotNull(message = "Le nom est obligatoire")
    private String nom;

    @Column(name = "telephone", length = 50)
    private String telephone;

    @Column(name = "adresse", length = 50)
    private String adresse;

}