package com.tulioreis.delivery.controller;

import com.tulioreis.delivery.model.Ingrediente;
import com.tulioreis.delivery.repository.IngredienteRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ingredientes")
@CrossOrigin(origins = "*")
public class IngredienteController {

    private final IngredienteRepository repository;

    public IngredienteController(IngredienteRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Ingrediente cadastrar(@RequestBody Ingrediente ingrediente) {
        return repository.save(ingrediente);
    }

    @GetMapping
    public List<Ingrediente> listar() {
        return repository.findAll();
    }
}