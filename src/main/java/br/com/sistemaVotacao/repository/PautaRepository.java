package br.com.sistemaVotacao.repository;

import br.com.sistemaVotacao.model.entity.Pauta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PautaRepository extends JpaRepository<Pauta, Long> {
}
