package com.mg.app.PharmaSys.model.medicament.Maladie;


import com.mg.app.PharmaSys.model.Maladies.Maladies;
import com.mg.app.PharmaSys.model.medicament.Medicament;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "medicaments_maladie")
public class MedicamentsMaladie {
    @EmbeddedId
    MedicamentMaladieId id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_medicament", insertable = false, updatable = false)
    private Medicament medicament;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_maladie", insertable = false, updatable = false)
    private Maladies maladie;


}
