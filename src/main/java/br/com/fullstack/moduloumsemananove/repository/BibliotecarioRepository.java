package br.com.fullstack.moduloumsemananove.repository;

import br.com.fullstack.moduloumsemananove.model.Bibliotecario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface BibliotecarioRepository extends JpaRepository<Bibliotecario, Long> {

    @Transactional
    @Modifying
    @Query("UPDATE Bibliotecario b SET b.nome = COALESCE(:nome, b.nome), b.email = COALESCE(:email, b.email), b.senha = COALESCE(:senha, b.senha) WHERE b.id = :bibliotecarioId")
    void updateBibliotecario(Long bibliotecarioId, String nome, String email, String senha);
}
