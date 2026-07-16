package com.tulioreis.delivery.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "itens_pedido")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer quantidade;

    private Double precoUnitario;

    private String observacao;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    @JsonIgnore
    private Pedido pedido;

    @ManyToMany
    @JoinTable(
            name = "item_pedido_adicionais",
            joinColumns = @JoinColumn(name = "item_pedido_id"),
            inverseJoinColumns = @JoinColumn(name = "adicional_id")
    )
    private List<Adicional> adicionais;

    @ManyToMany
    @JoinTable(
            name = "item_pedido_ingredientes_removidos",
            joinColumns = @JoinColumn(name = "item_pedido_id"),
            inverseJoinColumns = @JoinColumn(name = "ingrediente_id")
    )
    private List<Ingrediente> ingredientesRemovidos;

}