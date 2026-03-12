package br.ed.ufape.bahiabrindes.repository;

import br.ed.ufape.bahiabrindes.model.entity.ComentarioOrcamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComentarioOrcamentoRepository extends JpaRepository<ComentarioOrcamento, Long> {

    List<ComentarioOrcamento> findByOrcamentoIdOrderByCriadoEmAsc(Long orcamentoId);
}
