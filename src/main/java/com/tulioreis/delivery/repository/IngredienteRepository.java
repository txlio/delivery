package com.tulioreis.delivery.repository;

import com.tulioreis.delivery.model.Ingrediente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredienteRepository extends JpaRepository<Ingrediente, Long> {
}