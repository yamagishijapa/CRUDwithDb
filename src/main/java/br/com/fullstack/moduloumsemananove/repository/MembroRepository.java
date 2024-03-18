package br.com.fullstack.moduloumsemananove.repository;

import br.com.fullstack.moduloumsemananove.model.Membro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface MembroRepository extends JpaRepository<Membro, Long> {

    @Transactional
    @Modifying
    @Query("UPDATE Membro m SET m.endereco = COALESCE(:endereco, m.endereco), m.nome = COALESCE(:nome, m.nome), m.telefone = COALESCE(:telefone, m.telefone) WHERE m.id = :membroId")
    void updateMembro(Long membroId, String endereco, String nome, String telefone);
}
