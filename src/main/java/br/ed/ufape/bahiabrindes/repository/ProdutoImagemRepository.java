package br.ed.ufape.bahiabrindes.repository;

import br.ed.ufape.bahiabrindes.model.entity.ProdutoImagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoImagemRepository extends JpaRepository<ProdutoImagem, Long> {
}
