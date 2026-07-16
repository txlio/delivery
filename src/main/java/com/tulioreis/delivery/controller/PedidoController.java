package com.tulioreis.delivery.controller;

import com.tulioreis.delivery.model.ItemPedido;
import com.tulioreis.delivery.model.Pedido;
import com.tulioreis.delivery.model.StatusPedido;
import com.tulioreis.delivery.model.TipoEntrega;
import com.tulioreis.delivery.repository.PedidoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
@CrossOrigin(origins = "*")
public class PedidoController {

    private final PedidoRepository pedidoRepository;

    public PedidoController(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @PostMapping
    public Pedido criarPedido(@RequestBody Pedido pedido) {

        double totalItens = 0.0;

        for (ItemPedido item : pedido.getItens()) {
            item.setPedido(pedido);

            double subtotal = item.getPrecoUnitario() * item.getQuantidade();

            if (item.getAdicionais() != null) {
                for (var adicional : item.getAdicionais()) {
                    subtotal += adicional.getPreco() * item.getQuantidade();
                }
            }

            totalItens += subtotal;
        }

        double taxaEntrega = 0.0;

        if (pedido.getTipoEntrega() == TipoEntrega.ENTREGA) {
            taxaEntrega = pedido.getTaxaEntrega() != null ? pedido.getTaxaEntrega() : 0.0;
        }

        pedido.setTaxaEntrega(taxaEntrega);
        pedido.setTotal(totalItens + taxaEntrega);
        pedido.setStatus(StatusPedido.RECEBIDO);

        return pedidoRepository.save(pedido);
    }

    @GetMapping
    public List<Pedido> listarTodos() {
        return pedidoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Pedido buscarPorId(@PathVariable Long id) {
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
    }

    @PutMapping("/{id}/status")
    public Pedido atualizarStatus(
            @PathVariable Long id,
            @RequestParam StatusPedido status
    ) {
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));

        pedido.setStatus(status);

        return pedidoRepository.save(pedido);
    }

    @GetMapping("/status")
    public List<Pedido> listarPorStatus(@RequestParam StatusPedido status) {
        return pedidoRepository.findByStatus(status);
    }
}