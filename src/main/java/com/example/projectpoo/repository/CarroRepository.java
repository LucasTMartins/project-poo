package com.example.projectpoo.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.projectpoo.model.*;

import java.util.List;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Long> {
    List<Carro> findByNomeAndAtivo(String nome, Boolean status);
    List<Carro> findAllByNome(String nome, Pageable pageable);
}
