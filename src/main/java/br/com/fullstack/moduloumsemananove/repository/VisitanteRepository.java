package br.com.fullstack.moduloumsemananove.repository;

import br.com.fullstack.moduloumsemananove.model.Visitante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitanteRepository extends JpaRepository<Visitante, Long> {
}
