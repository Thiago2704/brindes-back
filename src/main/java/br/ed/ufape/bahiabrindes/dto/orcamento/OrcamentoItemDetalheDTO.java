package br.ed.ufape.bahiabrindes.dto.orcamento;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrcamentoItemDetalheDTO {

    private Long id;
    private Long produtoId;
    private String nomeProduto;
    private Integer quantidade;
    private String cor;
    private String variacao;
    private BigDecimal precoUnitario;
    private BigDecimal precoTotal;
    private String imagemUrl;
}

