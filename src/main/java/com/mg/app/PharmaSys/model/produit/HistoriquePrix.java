

package com.mg.app.PharmaSys.model.produit;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "historiqueprix")
public class HistoriquePrix {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @JoinColumn(name = "id_produit")
    @ManyToOne
    private Produit produit;

    @Column(name = "prix")
    private Double prix;


    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date_changement")
    private LocalDate date_changement;


}
