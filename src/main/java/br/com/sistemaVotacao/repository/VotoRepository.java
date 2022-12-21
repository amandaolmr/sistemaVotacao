package br.com.sistemaVotacao.repository;

import br.com.sistemaVotacao.model.entity.Voto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VotoRepository extends JpaRepository<Voto, Long> {
}
