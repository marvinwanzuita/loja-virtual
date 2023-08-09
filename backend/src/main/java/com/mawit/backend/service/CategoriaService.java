package com.mawit.backend.service;

import com.mawit.backend.entity.Categoria;
import com.mawit.backend.entity.Estado;
import com.mawit.backend.respository.CategoriaRepository;
import com.mawit.backend.respository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> buscarTodos(){
        return categoriaRepository.findAll();
    }

    public Categoria inserir(Categoria objeto){
        objeto.setDataCriacao(new Date());
        return categoriaRepository.saveAndFlush(objeto);
    }

    public Categoria alterar(Categoria objeto){
        objeto.setDataAtualizacao(new Date());
        return categoriaRepository.saveAndFlush(objeto);
    }

    public void excluir(Long id){
        Categoria objeto = categoriaRepository.findById(id).get();
        categoriaRepository.delete(objeto);
    }


}
