package br.com.fullstack.moduloumsemananove.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Emprestimo {
    @Id
    @Setter(AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "livro_id")
    private Livro livro;

    @ManyToOne
    @JoinColumn(name = "membro_id")
    private Membro membro;

    @Temporal(TemporalType.DATE)
    private Date dataEmprestimo;

    @Temporal(TemporalType.DATE)
    private Date dataDevolucao;
}
