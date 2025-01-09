package com.mg.app.PharmaSys.model.vente;

import com.mg.app.PharmaSys.model.produit.Produit;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

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
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime dateVente;


    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_produit", nullable = false)
    private Produit produit;

    @Column(name = "montant_total")
    private Double montantTotal;


    @Column(name = "quantite")
    private Double quantite;

    @OneToMany(mappedBy = "vente")
    private Set<VenteDetail> ventedetails = new LinkedHashSet<>();


}