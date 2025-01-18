package com.mg.app.PharmaSys.model.vente;

import com.mg.app.PharmaSys.model.caracteristique.Client;
import com.mg.app.PharmaSys.model.produit.Produit;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
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

    @Column(name = "montant_total")
    private Double montantTotal;


    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_client", nullable = false)
    private Client client;

    @OneToMany(mappedBy = "vente")
    private Set<VenteDetail> ventedetails = new LinkedHashSet<>();
}