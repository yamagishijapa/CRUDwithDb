package br.com.fullstack.moduloumsemananove.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class EmprestimoRequest {

    @NotNull
    private Long livroId;
    @NotNull
    private Long membroId;
    @NotNull
    private Date dataEmprestimo;
    @NotNull
    private Date dataDevolucao;
}
