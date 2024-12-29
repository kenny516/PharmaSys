package com.mg.app.PharmaSys.model.vente;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "vente")
public class Vente {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "date_vente")
    private LocalDateTime dateVente;

    @Column(name = "montant_total")
    private Double montantTotal;

    @OneToMany(mappedBy = "idVente")
    private Set<VenteDetail> ventedetails = new LinkedHashSet<>();

}