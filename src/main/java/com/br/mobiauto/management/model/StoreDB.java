package com.br.mobiauto.management.model;

import jakarta.persistence.*;
import lombok.Data;

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

//    @OneToMany(mappedBy = "resale", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JsonIgnore
//    private List<OportunityDB> opportunities;

}
