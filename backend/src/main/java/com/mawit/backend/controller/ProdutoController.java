package com.mawit.backend.controller;

import com.mawit.backend.entity.Produto;
import com.mawit.backend.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/")
    public List<Produto> buscarTodos(){
        return produtoService.buscarTodos();
    }

    @PostMapping("/")
    public Produto inserir(@RequestBody Produto objeto){
        return produtoService.inserir(objeto);
    }

    @PutMapping("/")
    public Produto alterar(@RequestBody Produto objeto){
        return produtoService.alterar(objeto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id){
        produtoService.excluir(id);
        return ResponseEntity.noContent().build();
    }

}
