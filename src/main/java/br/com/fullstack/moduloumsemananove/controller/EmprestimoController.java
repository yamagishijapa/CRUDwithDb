package br.com.fullstack.moduloumsemananove.controller;

import br.com.fullstack.moduloumsemananove.model.Emprestimo;
import br.com.fullstack.moduloumsemananove.request.EmprestimoRequest;
import br.com.fullstack.moduloumsemananove.response.errorValidation.ValidationErrorDetails;
import br.com.fullstack.moduloumsemananove.service.EmprestimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/emprestimo")
public class EmprestimoController {

    @Autowired
    private EmprestimoService emprestimoService;

    @PostMapping
    public Emprestimo criarEmprestimo(@RequestBody @Validated EmprestimoRequest emprestimo) {
        return emprestimoService.criarEmprestimo(emprestimo);
    }

    @GetMapping
    public List<Emprestimo> listarEmprestimo(){
        return emprestimoService.listarEmprestimo();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        return emprestimoService.deletarEmprestimo(id);
    }

    @PutMapping("/{emprestimoId}")
    public ResponseEntity<?> atualizarEmprestimo(@PathVariable Long emprestimoId,
                                                    @RequestParam(value = "dataEmprestimo", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dataEmprestimo,
                                                    @RequestParam(value = "dataDevolucao", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dataDevolucao) {
        return emprestimoService.atualizarEmprestimo(emprestimoId, dataEmprestimo, dataDevolucao);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<List<ValidationErrorDetails>> handleIllegalArgumentException(NoSuchElementException ex) {
        List<ValidationErrorDetails> errors = new ArrayList<>();
        errors.add(new ValidationErrorDetails(null, ex.getMessage()));
        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<List<ValidationErrorDetails>> handleValidationExceptions(MethodArgumentTypeMismatchException ex) {
        List<ValidationErrorDetails> errors = new ArrayList<>();
        errors.add(new ValidationErrorDetails(ex.getName(), "Parâmetro inválido: " + ex.getName() + " deve ser uma data no formato yyyy-MM-dd. " +
                "Verifique também se a data informada é uma data válida!"));
        return ResponseEntity.badRequest().body(errors);
    }
}
