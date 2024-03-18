package br.com.fullstack.moduloumsemananove.controller;

import br.com.fullstack.moduloumsemananove.model.Visitante;
import br.com.fullstack.moduloumsemananove.service.VisitanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/visitante")
public class VisitanteController {

    @Autowired
    private VisitanteService visitanteService;

    @PostMapping
    public Visitante criarVisitante(@RequestBody @Validated Visitante visitante) {
        return visitanteService.criarVisitante(visitante);
    }

    @GetMapping
    public List<Visitante> listarVisitante(){
        return visitanteService.listarVisitante();
    }
}
