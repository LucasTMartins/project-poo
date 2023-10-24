package com.example.projectpoo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.projectpoo.service.*;
import com.example.projectpoo.model.*;


import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/carro")
public class CarroController {

    @Autowired
    CarroService carroService;

    @PostMapping()
    public ResponseEntity<Carro> salvarCarro(@RequestBody Carro carro) {
        Carro response = carroService.salvar(carro);
        return ResponseEntity.ok(response);
    }

    @GetMapping(path = "/all", produces = "application/json")
    public ResponseEntity<List<Carro>> buscarTodos() {
        List<Carro> response = carroService.buscarTodos();
        return ResponseEntity.ok(response);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Carro> buscarPorId(@PathVariable Long id) {

        Optional<Carro> response = carroService.buscarPorId(id);
        if (response.isPresent()) {
            return ResponseEntity.ok(response.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping(path = "/nome/{nome}")
    public ResponseEntity<List<Carro>> buscarPorNome(@PathVariable String nome) {

        List<Carro> response = carroService.buscarPorNome(nome);
        if (response != null && !response.isEmpty()) {
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping()
    public ResponseEntity<Carro> update(@RequestBody Carro carro) {

        if (!carroService.buscarPorId(carro.getId()).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(carroService.atualizar(carro));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return carroService.deleteById(id);
    }
}
