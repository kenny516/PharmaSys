package com.mg.app.PharmaSys.model.vente;

import com.mg.app.PharmaSys.model.medicament.Medicament;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "vente_detail")
public class VenteDetail {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "quantite")
    private Double quantite;

    @Column(name = "prix_unitaire")
    private Double prixUnitaire;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_medicament", nullable = false)
    private Medicament medicament;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_vente", nullable = false)
    private Vente vente;

}