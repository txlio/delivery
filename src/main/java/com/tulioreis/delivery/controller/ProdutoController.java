package com.tulioreis.delivery.controller;

import com.tulioreis.delivery.model.Produto;
import com.tulioreis.delivery.repository.ProdutoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
@CrossOrigin(origins = "*")
public class ProdutoController {

    private final ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @PostMapping
    public Produto cadastrar(@RequestBody Produto produto) {
        produto.setAtivo(true);
        return produtoRepository.save(produto);
    }

    @GetMapping
    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    @GetMapping("/ativos")
    public List<Produto> listarAtivos() {
        return produtoRepository.findByAtivoTrue();
    }

    @PutMapping("/{id}")
    public Produto atualizar(
            @PathVariable Long id,
            @RequestBody Produto produtoAtualizado
    ) {

        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Produto não encontrado"));

        produto.setNome(produtoAtualizado.getNome());
        produto.setDescricao(produtoAtualizado.getDescricao());
        produto.setPreco(produtoAtualizado.getPreco());
        produto.setCategoria(produtoAtualizado.getCategoria());
        produto.setAtivo(produtoAtualizado.getAtivo());

        return produtoRepository.save(produto);
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id) {
        produtoRepository.deleteById(id);
    }
}