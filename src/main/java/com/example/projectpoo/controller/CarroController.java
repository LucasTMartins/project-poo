package com.example.projectpoo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.projectpoo.service.*;
import com.example.projectpoo.model.*;


import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/carro")
public class CarroController {

    @Autowired
    CarroService carroService;

    @PostMapping()
    public ResponseEntity<Carro> salvarCarro(@RequestBody Carro carro){
        Carro response = carroService.salvar(carro);
        return ResponseEntity.ok(response);
    }

    @GetMapping(path = "/all", produces = "application/json")
    public ResponseEntity<List<Carro>> buscarTodos(){
        List<Carro> response = carroService.buscarTodos();
        return ResponseEntity.ok(response);
    }
}
