package com.mg.app.PharmaSys.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommissionDTO {
    private Integer idVendeur;
    private String nom;
    private String prenom;
    private Double totalVentes;
    private Double commission;
    private String sexe;
}

