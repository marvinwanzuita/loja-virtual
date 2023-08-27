package com.mawit.backend.respository;

import com.mawit.backend.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaClienteRepository extends JpaRepository<Pessoa, Long> {
}
