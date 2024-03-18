package br.com.fullstack.moduloumsemananove.controller;

import br.com.fullstack.moduloumsemananove.model.Membro;
import br.com.fullstack.moduloumsemananove.service.MembroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/membro")
public class MembroController {

    @Autowired
    private MembroService membroService;

    @PostMapping
    public Membro criarMembro(@RequestBody @Validated Membro membro) {
        return membroService.criarMembro(membro);
    }

    @GetMapping
    public List<Membro> listarMembro(){
        return membroService.listarMembro();
    }
}
