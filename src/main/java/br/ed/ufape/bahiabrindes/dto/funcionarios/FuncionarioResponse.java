package br.ed.ufape.bahiabrindes.dto.funcionarios;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@Builder
public class FuncionarioResponse {

    private Long id;
    private String nome;
    private String email;
    private Boolean ativo;
    private Set<String> perfis;
    private LocalDateTime dtCriacao;
}