package com.mg.app.PharmaSys.model.configuration;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "parametre")
public class Parametre {
    @Id
    private String cle;

    @Column(name = "valeur")
    private Double valeur;

    @Column(name = "description")
    private String description;

}
