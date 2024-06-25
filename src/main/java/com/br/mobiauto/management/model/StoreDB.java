package com.br.mobiauto.management.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "STORES")
@Data
public class StoreDB {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String cnpj;

    private String nomeSocial;

    @OneToMany(mappedBy = "resale", cascade = CascadeType.ALL)
    private List<OportunityDB> opportunities;

}
