package br.com.fullstack.moduloumsemananove.service;

import br.com.fullstack.moduloumsemananove.model.Membro;
import br.com.fullstack.moduloumsemananove.repository.MembroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MembroService {

    @Autowired
    private MembroRepository membroRepository;

    public Membro criarMembro(Membro membro) {
        return membroRepository.save(membro);
    }

    public List<Membro> listarMembro(){
        return membroRepository.findAll();
    }

    public ResponseEntity<?> deletarMembro(Long id) {
        if(!membroRepository.existsById(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O membro com ID " + id + " não foi encontrado.");
        }

        membroRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
