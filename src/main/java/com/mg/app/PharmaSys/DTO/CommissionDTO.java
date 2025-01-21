package com.mg.app.PharmaSys.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CommissionDTO {
    private Long idVendeur;
    private String nom;
    private String prenom;
    private Double totalVentes;
    private Double commission;
}

