package com.mawit.backend.respository;

import com.mawit.backend.entity.ProdutoImagens;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoImagensRepository extends JpaRepository<ProdutoImagens, Long> {
}
