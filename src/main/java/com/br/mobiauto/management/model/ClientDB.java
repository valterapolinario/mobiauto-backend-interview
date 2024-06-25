package com.br.mobiauto.management.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "CLIENTS")
@Data
public class ClientDB {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String phone;
}
