package br.ed.ufape.bahiabrindes.dto.orcamento;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArteOrcamentoDTO {

    private Long id;

    /** Nome do produto relacionado à arte */
    private String produtoNome;

    /** URL da imagem da arte */
    private String imagemUrl;

    /** Status: PENDENTE | APROVADA | AJUSTE_SOLICITADO */
    private String status;

    /** Data de envio formatada (ex: "12/03/2026") */
    private String enviadoEm;
}
