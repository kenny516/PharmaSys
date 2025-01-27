package com.mg.app.PharmaSys.repository.vente;

import com.mg.app.PharmaSys.DTO.CommissionDTO;
import com.mg.app.PharmaSys.model.vente.Vente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface VenteRepository extends JpaRepository<Vente, Integer> {

    @Query(value = "SELECT DISTINCT v " + "FROM Vente v ")
    List<Vente> rechercheMulticritere();


    @Query(value = "SELECT DISTINCT v " + "FROM Vente v WHERE DATE(v.dateVente) = :date")
    List<Vente> rechercheClient(@Param("date") LocalDate date);

    @Query(value = """
            SELECT new com.mg.app.PharmaSys.DTO.CommissionDTO(
                        v.id,
                        v.nom,
                        v.prenom,
                        SUM(ve.montantTotal),
                        SUM(ve.commission),
                        s.nom
                        )
            FROM Vente ve
            JOIN Vendeur v ON ve.vendeur.id = v.id
            JOIN Sexe s on v.sexe.id = s.id
            WHERE DATE(ve.dateVente) BETWEEN :startDate AND :endDate
            AND (:id_sexe is NULL or s.id = :id_sexe)
            GROUP BY v.id, v.nom, v.prenom,s.nom
            """)
    List<CommissionDTO> filtreCommissionVendeurByIntervalleDateAndSexe(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate,@Param("id_sexe") Integer id_sexe);


}
