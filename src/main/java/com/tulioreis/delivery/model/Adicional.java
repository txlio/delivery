package com.tulioreis.delivery.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "adicionais")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Adicional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private Double preco;

    private Boolean ativo = true;
}