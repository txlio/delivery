package com.tulioreis.delivery.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "produtos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    private String descricao;

    @Column(nullable = false)
    private Double preco;

    private String imagemUrl;

    private Boolean ativo = true;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
}