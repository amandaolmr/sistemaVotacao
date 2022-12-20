package br.com.sistemaVotacao.model.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Data
@Entity
@Table(name = "sessoes")
public class VotoSessao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_voto_sessao")
    private Long idVotoSessao;

    @Column(name = "data_de_abertura")
    private LocalDateTime dataAbertura;

    @Column(name = "data_de_fechamento")
    private LocalDateTime dataFechamento;

    @OneToOne
    @JoinColumn(name = "id_pauta")
    private Pauta pauta;

    @OneToMany(mappedBy = "votoSessao")
    private List<Voto> votos;
}
