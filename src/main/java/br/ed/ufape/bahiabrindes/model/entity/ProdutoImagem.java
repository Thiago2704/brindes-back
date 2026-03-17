package br.ed.ufape.bahiabrindes.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "produto_imagens")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoImagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "produto_id", nullable = false)
    private Produto produto;


    @Column(name = "url", nullable = false, length = 2048)
    private String url;

    @Builder.Default
    @Column(name = "ordem", nullable = false)
    private Integer ordem = 1;
}
