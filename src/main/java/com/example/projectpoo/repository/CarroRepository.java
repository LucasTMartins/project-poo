package com.example.projectpoo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.projectpoo.model.*;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Long> {
}
