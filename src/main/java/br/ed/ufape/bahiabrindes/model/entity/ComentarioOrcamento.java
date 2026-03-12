package br.ed.ufape.bahiabrindes.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "comentarios_orcamento")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ComentarioOrcamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "orcamento_id", nullable = false)
    private Orcamento orcamento;

    /** Nome de quem enviou o comentário (cliente ou funcionário) */
    @Column(name = "autor", nullable = false)
    private String autor;

    @Column(name = "mensagem", nullable = false, columnDefinition = "TEXT")
    private String mensagem;

    @CreationTimestamp
    @Column(name = "criado_em", nullable = false, updatable = false)
    private LocalDateTime criadoEm;
}
