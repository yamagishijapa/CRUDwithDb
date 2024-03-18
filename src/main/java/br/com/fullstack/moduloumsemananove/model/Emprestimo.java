package br.com.fullstack.moduloumsemananove.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Emprestimo {
    @Id
    @Setter(AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long emprestimo_id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "livro_id")
    private Livro livro;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "membro_id")
    private Membro membro;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date dataEmprestimo;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date dataDevolucao;

    public Emprestimo(Livro livro, Membro membro, Date dataEmprestimo, Date dataDevolucao) {
        this.livro = livro;
        this.membro = membro;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
    }
}
