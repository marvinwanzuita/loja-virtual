package com.mawit.backend.service;

import com.mawit.backend.entity.Marca;
import com.mawit.backend.entity.Permissao;
import com.mawit.backend.respository.PermissaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PermissaoService {

    @Autowired
    private PermissaoRepository permissaoRepository;

    public List<Permissao> buscarTodos(){
        return permissaoRepository.findAll();
    }

    public Permissao inserir(Permissao objeto){
        objeto.setDataCriacao(new Date());
        return permissaoRepository.saveAndFlush(objeto);
    }

    public Permissao alterar(Permissao objeto){
        objeto.setDataAtualizacao(new Date());
        return permissaoRepository.saveAndFlush(objeto);
    }

    public void excluir(Long id){
        Permissao objeto = permissaoRepository.findById(id).get();
        permissaoRepository.delete(objeto);
    }

}
