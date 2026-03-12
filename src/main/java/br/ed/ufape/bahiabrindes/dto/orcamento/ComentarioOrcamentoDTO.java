package br.ed.ufape.bahiabrindes.dto.orcamento;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ComentarioOrcamentoDTO {
    private Long id;
    private String autor;
    private String mensagem;
    /** Data/hora formatada: "dd/MM/yyyy HH:mm" */
    private String criadoEm;
}
