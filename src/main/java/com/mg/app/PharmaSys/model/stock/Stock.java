package com.mg.app.PharmaSys.model.stock;

import com.mg.app.PharmaSys.model.medicament.Medicament;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "stock")
public class Stock {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "quantite_disponible")
    private Double quantiteDisponible;

    @Column(name = "date_dernier_mouvement")
    private LocalDateTime dateDernierMouvement;

    @Column(name = "date_peremption")
    private LocalDate datePeremption;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_medicament", nullable = false)
    private Medicament Medicament;

}