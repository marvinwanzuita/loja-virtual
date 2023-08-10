package com.mawit.backend.controller;

import com.mawit.backend.entity.Cidade;
import com.mawit.backend.entity.Estado;
import com.mawit.backend.service.CidadeService;
import com.mawit.backend.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cidade")
public class CidadeController {

    @Autowired
    private CidadeService cidadeService;

    @GetMapping("/")
    public List<Cidade> buscarTodos(){
        return cidadeService.buscarTodos();
    }

    @PostMapping("/")
    public Cidade inserir(@RequestBody Cidade objeto){
        return cidadeService.inserir(objeto);
    }

    @PutMapping("/")
    public Cidade alterar(@RequestBody Cidade objeto){
        return cidadeService.alterar(objeto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id){
        cidadeService.excluir(id);
        return ResponseEntity.noContent().build();
    }


}
