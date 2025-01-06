package com.mg.app.PharmaSys.model.medicament.publicCible;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Embeddable
public class MedicamentsPublicCibleId {
    @Column(name = "id_medicament")
    private Integer idMedicament;
    @Column(name = "id_public")
    private Integer idPublic;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // Vérifie si c'est le même objet en mémoire
        if (o == null || getClass() != o.getClass()) return false; // Vérifie si l'objet est du même type
        MedicamentsPublicCibleId that = (MedicamentsPublicCibleId) o; // Cast de l'objet comparé
        return idMedicament.equals(that.idMedicament) && idPublic.equals(that.idPublic); // Comparaison des valeurs
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMedicament, idPublic); // Calcul du hash basé sur les deux champs
    }

}
