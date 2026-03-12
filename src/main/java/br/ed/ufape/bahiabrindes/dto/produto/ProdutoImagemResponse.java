package br.ed.ufape.bahiabrindes.dto.produto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoImagemResponse {

    private Long id;
    private String url;
    private Integer ordem;
}
