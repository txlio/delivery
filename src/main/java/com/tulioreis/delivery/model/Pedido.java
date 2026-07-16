package com.tulioreis.delivery.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "pedidos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeCliente;

    private String telefoneCliente;

    private String enderecoEntrega;

    private Double total;

    private LocalDateTime dataHora = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    private StatusPedido status = StatusPedido.RECEBIDO;

    @Enumerated(EnumType.STRING)
    private FormaPagamento formaPagamento;

    @Enumerated(EnumType.STRING)
    private TipoEntrega tipoEntrega;

    private Double taxaEntrega = 0.0;

    private String observacaoGeral;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<ItemPedido> itens;
}