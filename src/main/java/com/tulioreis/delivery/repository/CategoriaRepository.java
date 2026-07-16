package com.tulioreis.delivery.repository;

import com.tulioreis.delivery.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}