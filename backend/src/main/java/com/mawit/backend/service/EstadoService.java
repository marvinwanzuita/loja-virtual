package com.mawit.backend.service;

import com.mawit.backend.entity.Estado;
import com.mawit.backend.respository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    public List<Estado> buscarTodos(){
        return estadoRepository.findAll();
    }

    public Estado inserir(Estado objeto){
        objeto.setDataCriacao(new Date());
        return estadoRepository.saveAndFlush(objeto);
    }

    public Estado alterar(Estado objeto){
        objeto.setDataAtualizacao(new Date());
        return estadoRepository.saveAndFlush(objeto);
    }

    public void excluir(Long id){
        Estado estado = estadoRepository.findById(id).get();
        estadoRepository.delete(estado);
    }


}
