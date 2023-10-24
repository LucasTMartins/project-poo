package com.example.projectpoo.controller;

import com.example.projectpoo.model.Locatario;
import com.example.projectpoo.service.LocatarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/locatario")
public class LocatarioController {
    @Autowired
    LocatarioService locatarioService;

    @PostMapping()
    public ResponseEntity<Locatario> salvarLocatario(@RequestBody Locatario locatario){

        Locatario response = locatarioService.salvar(locatario);
        return ResponseEntity.ok(response);
    }

    @GetMapping(path = "/all", produces = "application/json")
    public ResponseEntity<List<Locatario>> buscarTodos(){

        List<Locatario> response = locatarioService.buscarTodos();
        return ResponseEntity.ok(response);
    }
}
