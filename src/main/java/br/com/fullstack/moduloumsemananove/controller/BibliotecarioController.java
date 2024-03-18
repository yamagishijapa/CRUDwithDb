package br.com.fullstack.moduloumsemananove.controller;

import br.com.fullstack.moduloumsemananove.model.Bibliotecario;
import br.com.fullstack.moduloumsemananove.service.BibliotecarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bibliotecario")
public class BibliotecarioController {

    @Autowired
    private BibliotecarioService bibliotecarioService;

    @PostMapping
    public Bibliotecario criarBibliotecario(@RequestBody @Validated Bibliotecario bibliotecario) {
        return bibliotecarioService.criarBibliotecario(bibliotecario);
    }

    @GetMapping
    public List<Bibliotecario> listarBibliotecario(){
        return bibliotecarioService.listarBibliotecario();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        return bibliotecarioService.deletarBibliotecario(id);
    }

    @PutMapping("/{bibliotecarioId}")
    public ResponseEntity<?> atualizarBibliotecario(@PathVariable Long bibliotecarioId,
                                            @RequestParam(value = "nome", required = false) String nome,
                                            @RequestParam(value = "email", required = false) String email,
                                            @RequestParam(value = "senha", required = false) String senha) {
        return bibliotecarioService.atualizarBibliotecario(bibliotecarioId, nome, email, senha);
    }
}
