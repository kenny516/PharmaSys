package com.mg.app.PharmaSys.model.medicament.publicCible;


import com.mg.app.PharmaSys.model.medicament.Medicament;
import com.mg.app.PharmaSys.model.medicament.PublicCible;
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
@Table(name = "medicaments_public_cible")
public class MedicamentsPublicCible {

    @EmbeddedId
    private MedicamentsPublicCibleId id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_medicament", insertable = false, updatable = false)
    private Medicament medicament;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_public", insertable = false, updatable = false)
    private PublicCible publicCible;
}
