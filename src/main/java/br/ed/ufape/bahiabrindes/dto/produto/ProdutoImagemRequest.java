package br.ed.ufape.bahiabrindes.dto.produto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoImagemRequest {

    @NotBlank(message = "A URL da imagem é obrigatória")
    private String url;

    private Integer ordem;
}
