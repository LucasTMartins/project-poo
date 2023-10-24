package com.example.projectpoo.service;

import com.example.projectpoo.model.Locatario;
import com.example.projectpoo.repository.LocatarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocatarioService {
    @Autowired
    LocatarioRepository locatarioRepository;

    public Locatario salvar(Locatario locatario) {
        return locatarioRepository.save(locatario);
    }

    public List<Locatario> buscarTodos() {
        return locatarioRepository.findAll();
    }
}