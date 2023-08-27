package com.mawit.backend.service;

import com.mawit.backend.dto.PessoaClienteRequestDTO;
import com.mawit.backend.entity.Pessoa;
import com.mawit.backend.respository.PermissaoRepository;
import com.mawit.backend.respository.PessoaClienteRepository;
import com.mawit.backend.respository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PessoaClienteService {

    @Autowired
    private PessoaClienteRepository pessoaRepository;

    @Autowired
    private PermissaoPessoaService permissaoPessoaService;

    @Autowired
    private EmailService emailService;

    public Pessoa registrar(PessoaClienteRequestDTO pessoaClienteRequestDTO){
        Pessoa pessoa = new PessoaClienteRequestDTO().converter(pessoaClienteRequestDTO);
        pessoa.setDataCriacao(new Date());
        Pessoa objetoNovo = pessoaRepository.saveAndFlush(pessoa);
        permissaoPessoaService.vincularPessoaPermissaoCliente(objetoNovo);
        emailService.enviarEmailTexto(
                objetoNovo.getEmail(),
                "Cadastro na Loja Virtual",
                "Cadastro realizado com sucesso! Em breve a senha de acesso por email");
        return objetoNovo;
    }


}
