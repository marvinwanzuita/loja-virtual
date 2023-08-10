package com.mawit.backend.service;

import com.mawit.backend.entity.Categoria;
import com.mawit.backend.entity.Cidade;
import com.mawit.backend.respository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    public List<Cidade> buscarTodos(){
        return cidadeRepository.findAll();
    }

    public Cidade inserir(Cidade objeto){
        objeto.setDataCriacao(new Date());
        return cidadeRepository.saveAndFlush(objeto);
    }

    public Cidade alterar(Cidade objeto){
        objeto.setDataAtualizacao(new Date());
        return cidadeRepository.saveAndFlush(objeto);
    }

    public void excluir(Long id){
        Cidade objeto = cidadeRepository.findById(id).get();
        cidadeRepository.delete(objeto);
    }

}
