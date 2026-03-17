package br.ed.ufape.bahiabrindes.repository;

import br.ed.ufape.bahiabrindes.model.entity.HistoricoStatusOrcamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistoricoStatusOrcamentoRepository extends JpaRepository<HistoricoStatusOrcamento, Long> {

    List<HistoricoStatusOrcamento> findByOrcamentoIdOrderByDataAsc(Long orcamentoId);
}
