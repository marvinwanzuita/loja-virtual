package com.mawit.backend.service;

import com.mawit.backend.entity.Marca;
import com.mawit.backend.entity.Produto;
import com.mawit.backend.respository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> buscarTodos(){
        return produtoRepository.findAll();
    }

    public Produto inserir(Produto objeto){
        objeto.setDataCriacao(new Date());
        return produtoRepository.saveAndFlush(objeto);
    }

    public Produto alterar(Produto objeto){
        objeto.setDataAtualizacao(new Date());
        return produtoRepository.saveAndFlush(objeto);
    }

    public void excluir(Long id){
        Produto objeto = produtoRepository.findById(id).get();
        produtoRepository.delete(objeto);
    }


}
