package com.example.projectpoo.model;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
public class Locatario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String nome;

    @ManyToOne
    @JoinColumn(name = "id_carro")
    Carro carro;
}
