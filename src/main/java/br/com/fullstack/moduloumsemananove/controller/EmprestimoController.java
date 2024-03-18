package br.com.fullstack.moduloumsemananove.controller;

import br.com.fullstack.moduloumsemananove.model.Emprestimo;
import br.com.fullstack.moduloumsemananove.request.EmprestimoRequest;
import br.com.fullstack.moduloumsemananove.response.errorValidation.ValidationErrorDetails;
import br.com.fullstack.moduloumsemananove.service.EmprestimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<List<ValidationErrorDetails>> handleIllegalArgumentException(NoSuchElementException ex) {
        List<ValidationErrorDetails> errors = new ArrayList<>();
        errors.add(new ValidationErrorDetails(null, ex.getMessage()));
        return ResponseEntity.badRequest().body(errors);
    }
}
