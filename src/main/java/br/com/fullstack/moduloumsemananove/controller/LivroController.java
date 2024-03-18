package br.com.fullstack.moduloumsemananove.controller;

import br.com.fullstack.moduloumsemananove.model.Livro;
import br.com.fullstack.moduloumsemananove.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livro")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @PostMapping
    public Livro criarLivro(@RequestBody @Validated Livro livro) {
        return livroService.criarLivro(livro);
    }

    @GetMapping
    public List<Livro> listarLivro(){
        return livroService.listarLivro();
    }
}
