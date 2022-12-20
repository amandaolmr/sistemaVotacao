package br.com.sistemaVotacao.model.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;



@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Data
@Entity
@Table(name = "pautas")
public class Pauta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pauta")
    private Long idPauta;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "descricao")
    private String descricao;
}
