package com.totalshakes.wstotalshakes.model;

import javax.persistence.*;

@Entity
public class Adicional {

    @Id
    @Column(name = "adicional_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "ingrediente_id")
    private Ingrediente ingrediente;
}
