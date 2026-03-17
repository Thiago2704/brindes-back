package br.ed.ufape.bahiabrindes.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "historico_status_orcamento")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HistoricoStatusOrcamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "orcamento_id", nullable = false)
    private Orcamento orcamento;

    /** Valor do enum StatusOrcamento (ex: ORCAMENTO_SOLICITADO) */
    @Column(name = "status", nullable = false, length = 40)
    private String status;

    /** Título legível para exibição na timeline */
    @Column(name = "titulo", nullable = false)
    private String titulo;

    /** Descrição adicional do evento */
    @Column(name = "descricao", nullable = false)
    private String descricao;

    /** Quem realizou a ação (funcionário, sistema etc.) */
    @Column(name = "responsavel")
    private String responsavel;

    @CreationTimestamp
    @Column(name = "data", nullable = false, updatable = false)
    private LocalDateTime data;
}
