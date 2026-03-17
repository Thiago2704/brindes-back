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
public class AdminOrcamentoListItemDTO {

    private Long id;
    private String codigo;
    private String status;
    private String dataCriacao;
    private BigDecimal valorTotal;
    private int numProdutos;
    private String nomeCliente;
    private String telefoneCliente;
}
