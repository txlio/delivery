package com.tulioreis.delivery.controller;

import com.tulioreis.delivery.model.Categoria;
import com.tulioreis.delivery.repository.CategoriaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
@CrossOrigin(origins = "*")
public class CategoriaController {

    private final CategoriaRepository categoriaRepository;

    public CategoriaController(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @PostMapping
    public Categoria cadastrar(@RequestBody Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @GetMapping
    public List<Categoria> listar() {
        return categoriaRepository.findAll();
    }
}