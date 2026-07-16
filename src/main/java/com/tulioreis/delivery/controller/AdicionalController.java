package com.tulioreis.delivery.controller;

import com.tulioreis.delivery.model.Adicional;
import com.tulioreis.delivery.repository.AdicionalRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adicionais")
@CrossOrigin(origins = "*")
public class AdicionalController {

    private final AdicionalRepository adicionalRepository;

    public AdicionalController(AdicionalRepository adicionalRepository) {
        this.adicionalRepository = adicionalRepository;
    }

    @PostMapping
    public Adicional cadastrar(@RequestBody Adicional adicional) {
        return adicionalRepository.save(adicional);
    }

    @GetMapping
    public List<Adicional> listarTodos() {
        return adicionalRepository.findAll();
    }

    @GetMapping("/ativos")
    public List<Adicional> listarAtivos() {
        return adicionalRepository.findByAtivoTrue();
    }
}