package com.totalshakes.wstotalshakes.model;

import javax.persistence.*;

@Entity

@Table(name = "ingrediente")
public class Ingrediente {

    @Id
    @Column(name = "ingrediente_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ingrediente_nome")
    private String nome;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}