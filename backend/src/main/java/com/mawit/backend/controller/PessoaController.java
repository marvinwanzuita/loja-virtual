package com.mawit.backend.controller;

import com.mawit.backend.entity.Pessoa;
import com.mawit.backend.entity.Produto;
import com.mawit.backend.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping("/")
    public List<Pessoa> buscarTodos(){
        return pessoaService.buscarTodos();
    }

    @PostMapping("/")
    public Pessoa inserir(@RequestBody Pessoa objeto){
        return pessoaService.inserir(objeto);
    }

    @PutMapping("/")
    public Pessoa alterar(@RequestBody Pessoa objeto){
        return pessoaService.alterar(objeto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id){
        pessoaService.excluir(id);
        return ResponseEntity.noContent().build();
    }


}
