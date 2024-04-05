package br.com.fullstack.moduloumsemananove.repository;

import br.com.fullstack.moduloumsemananove.model.Visitante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface VisitanteRepository extends JpaRepository<Visitante, Long> {

    @Transactional
    @Modifying
    @Query("UPDATE Visitante v SET v.nome = " +
            "COALESCE(:nome, v.nome), v.telefone = " +
            "COALESCE(:telefone, v.telefone) WHERE v.id = :visitanteId")
    void updateVisitante(Long visitanteId, String nome, String telefone);
}
