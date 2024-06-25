package com.br.mobiauto.management.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "USERS")
@Data
public class UserDB {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "email", unique = true)
    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private UserPositionEnum position;

    @ManyToOne
    @JoinColumn(name = "id_store")
    private StoreDB store;


}
