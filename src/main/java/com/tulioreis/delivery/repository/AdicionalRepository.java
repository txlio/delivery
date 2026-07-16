package com.tulioreis.delivery.repository;

import com.tulioreis.delivery.model.Adicional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdicionalRepository extends JpaRepository<Adicional, Long> {

    List<Adicional> findByAtivoTrue();
}