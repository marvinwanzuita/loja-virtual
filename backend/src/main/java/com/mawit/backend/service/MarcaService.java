package com.mawit.backend.service;

import com.mawit.backend.entity.Estado;
import com.mawit.backend.entity.Marca;
import com.mawit.backend.respository.EstadoRepository;
import com.mawit.backend.respository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MarcaService {

    @Autowired
    private MarcaRepository marcaRepository;

    public List<Marca> buscarTodos(){
        return marcaRepository.findAll();
    }

    public Marca inserir(Marca objeto){
        objeto.setDataCriacao(new Date());
        return marcaRepository.saveAndFlush(objeto);
    }

    public Marca alterar(Marca objeto){
        objeto.setDataAtualizacao(new Date());
        return marcaRepository.saveAndFlush(objeto);
    }

    public void excluir(Long id){
        Marca objeto = marcaRepository.findById(id).get();
        marcaRepository.delete(objeto);
    }


}
