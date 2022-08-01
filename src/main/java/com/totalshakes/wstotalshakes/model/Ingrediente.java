package com.totalshakes.wstotalshakes.model;

import javax.persistence.*;

@Entity
@Table(name = "ingrediente")
public class Ingrediente {
    @Id
    @Column(name = "ingrediente_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "ingrediente_nome")
    private String nome;

}