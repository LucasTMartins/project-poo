package com.example.projectpoo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.projectpoo.repository.*;
import com.example.projectpoo.model.*;

import java.util.List;
import java.util.Optional;

@Service
public class CarroService {
    @Autowired
    CarroRepository carroRepository;

   public Carro salvar(Carro carro){
       carro.setAtivo(true);
       return carroRepository.save(carro);
   }

   public List<Carro> buscarTodos(){
       List<Carro> response = carroRepository.findAll();
       response.removeIf(carro-> !carro.getAtivo());
       return carroRepository.findAll();
   }

    public Optional<Carro> buscarPorId(Long id){
        return carroRepository.findById(id);
    }

    public Carro atualizar(Carro carro){
        return carroRepository.save(carro);
    }

    public List<Carro> buscarPorNome(String nome){
        return carroRepository.findByNomeAndAtivo(nome, true);
    }

    public ResponseEntity<?> deleteById(Long id) {

        Optional<Carro> response = buscarPorId(id);

        if (response.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        response.get().setAtivo(false);

        return ResponseEntity.ok(carroRepository.save(response.get())) ;
    }
}
