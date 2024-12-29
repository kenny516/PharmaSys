package com.mg.app.PharmaSys.model.stock;

import com.mg.app.PharmaSys.model.medicament.Medicament;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "mvtstock")
public class MvtStock {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "date_mvt")
    private LocalDateTime dateMvt;

    @Column(name = "quantite")
    private Integer quantite;

    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_type_mvt", nullable = false)
    private TypeMvtStock idTypeMvt;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_medicament", nullable = false)
    private Medicament idMedicament;

}