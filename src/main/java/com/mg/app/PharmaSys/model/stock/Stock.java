package com.mg.app.PharmaSys.model.stock;

import com.mg.app.PharmaSys.model.produit.Produit;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Immutable;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "v_stock")
@Immutable
public class Stock {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "quantite_disponible")
    private Double quantiteDisponible;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date_peremption")
    private LocalDate datePeremption;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_produit", nullable = false)
    private Produit produit;

}