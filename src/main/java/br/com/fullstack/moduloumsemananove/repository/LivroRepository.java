package br.com.fullstack.moduloumsemananove.repository;

import br.com.fullstack.moduloumsemananove.model.Livro;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

    @Transactional
    @Modifying
    @Query("UPDATE Livro l SET l.titulo = COALESCE(:titulo, l.titulo), l.autor = COALESCE(:autor, l.autor), l.anoPublicacao = COALESCE(:anoPublicacao, l.anoPublicacao) WHERE l.id = :livroId")
    void updateLivro(Long livroId, String titulo, String autor, Integer anoPublicacao);
}
