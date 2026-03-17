package br.ed.ufape.bahiabrindes.dto.orcamento;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CriarOrcamentoRequest {

    @NotEmpty
    @Valid
    private List<CriarOrcamentoItemRequest> itens;

    private String observacoes;
}

