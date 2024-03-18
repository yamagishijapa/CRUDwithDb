package br.com.fullstack.moduloumsemananove.controller;

import br.com.fullstack.moduloumsemananove.model.Membro;
import br.com.fullstack.moduloumsemananove.service.MembroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        return membroService.deletarMembro(id);
    }

    @PutMapping("/{membroId}")
    public ResponseEntity<?> atualizarMembro(@PathVariable Long membroId,
                                                    @RequestParam(value = "endereco", required = false) String endereco,
                                                    @RequestParam(value = "nome", required = false) String nome,
                                                    @RequestParam(value = "telefone", required = false) String telefone) {
        return membroService.atualizarMembro(membroId, endereco, nome, telefone);
    }
}
