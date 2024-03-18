package br.com.fullstack.moduloumsemananove.repository;

import br.com.fullstack.moduloumsemananove.model.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Repository
public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {

    @Transactional
    @Modifying
    @Query("UPDATE Emprestimo e SET e.dataDevolucao = COALESCE(:dataDevolucao, e.dataDevolucao), e.dataEmprestimo = COALESCE(:dataEmprestimo, e.dataEmprestimo) WHERE e.id = :emprestimoId")
    void updateEmprestimo(Long emprestimoId, LocalDate dataDevolucao, LocalDate dataEmprestimo);
}