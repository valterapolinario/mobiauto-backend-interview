package com.br.mobiauto.management.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "VEHICLES")
@Data
public class VehicleDB {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand;
    private String model;
    private String version;
    private int yearOfRelease;
}
