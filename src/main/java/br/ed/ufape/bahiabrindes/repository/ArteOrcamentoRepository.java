package br.ed.ufape.bahiabrindes.repository;

import br.ed.ufape.bahiabrindes.model.entity.ArteOrcamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArteOrcamentoRepository extends JpaRepository<ArteOrcamento, Long> {

    List<ArteOrcamento> findByOrcamentoIdOrderByEnviadoEmAsc(Long orcamentoId);
}
