package br.ed.ufape.bahiabrindes.dto.orcamento;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HistoricoStatusItemDTO {

    private Long id;

    /** Valor do enum (ex: ORCAMENTO_SOLICITADO) */
    private String status;

    /** Título legível (ex: "Orçamento Solicitado") */
    private String titulo;

    /** Descrição do evento */
    private String descricao;

    /** Data formatada para exibição (ex: "12/03/2026 às 14:30") */
    private String data;

    /** Responsável pela ação (opcional) */
    private String responsavel;
}
