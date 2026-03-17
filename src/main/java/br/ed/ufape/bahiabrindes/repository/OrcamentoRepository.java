package br.ed.ufape.bahiabrindes.repository;

import br.ed.ufape.bahiabrindes.model.entity.Orcamento;
import br.ed.ufape.bahiabrindes.model.enums.StatusOrcamento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrcamentoRepository extends JpaRepository<Orcamento, Long> {

    Page<Orcamento> findByClienteIdOrderByDataCriacaoDesc(Long clienteId, Pageable pageable);

    Page<Orcamento> findAllByOrderByDataCriacaoDesc(Pageable pageable);

    Page<Orcamento> findByStatusOrderByDataCriacaoDesc(StatusOrcamento status, Pageable pageable);
}

