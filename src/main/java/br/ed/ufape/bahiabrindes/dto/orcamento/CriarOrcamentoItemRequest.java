package br.ed.ufape.bahiabrindes.dto.orcamento;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CriarOrcamentoItemRequest {

    @NotNull
    private Long produtoId;

    @NotNull
    @Min(1)
    private Integer quantidade;

    private String cor;
    private String impressao;
}

