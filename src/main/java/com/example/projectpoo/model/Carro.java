package com.example.projectpoo.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Carro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String nome;
}
