package com.mg.app.PharmaSys.model.fournisseur;

import com.mg.app.PharmaSys.model.produit.Produit;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "entree_fournisseur")
public class EntreeFournisseur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "quantite")
    private Double quantite;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date_peremption")
    private LocalDate datePeremption;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Column(name = "date_entree")
    private LocalDateTime dateEntree;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_produit")
    private Produit produit;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_fournisseur")
    private Fournisseur fournisseur;


}
