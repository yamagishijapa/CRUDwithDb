package br.com.fullstack.moduloumsemananove.controller;

import br.com.fullstack.moduloumsemananove.model.Bibliotecario;
import br.com.fullstack.moduloumsemananove.service.BibliotecarioService;
import org.springframework.beans.factory.annotation.Autowired;
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
}
