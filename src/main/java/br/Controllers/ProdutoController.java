package br.Controllers;


import br.model.Produto;

import br.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.lang.*;
import java.util.Optional;


@RestController
@RequestMapping("/api")
public class ProdutoController {

    @Autowired
    private static ProdutoRepository produtoRepository;


    @GetMapping("/produtos")
    public ResponseEntity<List<Produto>> getAllProdutos() {
        try {
            List<Produto> produtos = produtoRepository.findAll();
            if (produtos.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(produtos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/produtos/{id}")
    public ResponseEntity<Produto> getProdutoPorId(@PathVariable("id") long id) {
        Optional<Produto> produtoData = produtoRepository.findById(id);
        if (produtoData.isPresent()) {
            return new ResponseEntity<>(produtoData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/produtos")
    public ResponseEntity<Produto> addProduto(@RequestBody Produto produto) {
        try {
            Produto produtoNovo = produtoRepository.save(produto);
            return new ResponseEntity<>(produtoNovo, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/produtos/{id}")
    public ResponseEntity<Produto> updateProduto(@PathVariable("id") long id, @RequestBody Produto produto) {
        Optional<Produto> produtoData = produtoRepository.findById(id);
        if (produtoData.isPresent()) {
            return new ResponseEntity<>(produtoRepository.save(produto), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/produtos/{id}")
    public ResponseEntity<Produto> deleteProduto(@PathVariable("id") long id) {
        try {
            produtoRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}