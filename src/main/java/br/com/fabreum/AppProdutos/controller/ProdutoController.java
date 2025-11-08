package br.com.fabreum.AppProdutos.controller;

import br.com.fabreum.AppProdutos.model.Produtos;
import br.com.fabreum.AppProdutos.repository.ProdutosRepository;
import br.com.fabreum.AppProdutos.service.ProdutosService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/produtos/")
public class ProdutoController {

    private final ProdutosRepository produtosRepository;
    private final ProdutosService produtosService;

    @PostMapping("produto")
    public ResponseEntity<Produtos> criaProduto(@RequestBody Produtos produto) {
        Produtos saved = produtosRepository.save(produto);
        return ResponseEntity.ok(saved);
    }

    @GetMapping
    public ResponseEntity<List<Produtos>> listaProdutos() {
        List<Produtos> produtos = produtosRepository.findAll();
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("{id}")
    public ResponseEntity<Produtos> listaProdutoPorId(@PathVariable Long id) {
        Produtos produto = produtosRepository.findById(id).orElseThrow();
        return ResponseEntity.ok(produto);
    }

    @PutMapping("atualiza")
    public ResponseEntity<Optional<Produtos>> atualizaProduto(@RequestBody Produtos produto) {
        final var produtoExistente = produtosService.atualizaProduto(produto);
        return ResponseEntity.ok(produtoExistente);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletaProduto(@PathVariable Long id) {
        produtosRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
