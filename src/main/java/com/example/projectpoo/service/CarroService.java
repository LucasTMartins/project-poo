package com.example.projectpoo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.projectpoo.repository.*;
import com.example.projectpoo.model.*;

import java.util.List;

@Service
public class CarroService {
    @Autowired
    CarroRepository carroRepository;

   public Carro salvar(Carro carro){
       return carroRepository.save(carro);
   }

   public List<Carro> buscarTodos(){
       return carroRepository.findAll();
   }
}
