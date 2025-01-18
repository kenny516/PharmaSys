package com.mg.app.PharmaSys.model.produit;// Entity class for ProduitConseil

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Produit_conseil")
public class ProduitConseil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @JoinColumn(name = "id_produit", nullable = false)
    @ManyToOne()
    public Produit produit;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date_debut", nullable = false)
    public LocalDate dateDebut;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date_fin", nullable = false)
    public LocalDate dateFin;

    @Column(name = "description", columnDefinition = "TEXT")
    public String description;


}
