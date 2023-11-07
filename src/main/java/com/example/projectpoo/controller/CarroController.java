package com.example.projectpoo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.projectpoo.model.Carro;
import com.example.projectpoo.repository.CarroRepository;
import com.example.projectpoo.service.CarroService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/carro")
public class CarroController {

    @Autowired
    CarroService carroService;

    @Autowired
    private CarroRepository carroRepository;

    @GetMapping("/produtos")
    public Page<Carro> getProdutos(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return carroRepository.findAll(pageRequest);
    }

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
