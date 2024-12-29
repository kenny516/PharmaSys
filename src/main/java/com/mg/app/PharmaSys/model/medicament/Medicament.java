package com.mg.app.PharmaSys.model.medicament;

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
@Table(name = "medicament")
public class Medicament {
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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_laboratoire")
    private Laboratoire idLaboratoire;

}