package br.com.fullstack.moduloumsemananove.service;

import br.com.fullstack.moduloumsemananove.model.Visitante;
import br.com.fullstack.moduloumsemananove.repository.VisitanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitanteService {

    @Autowired
    VisitanteRepository visitanteRepository;

    public Visitante criarVisitante(Visitante visitante){
        return visitanteRepository.save(visitante);
    }

    public List<Visitante> listarVisitante(){
        return visitanteRepository.findAll();
    }

    public ResponseEntity<?> deletarVisitante(Long id) {
        if(!visitanteRepository.existsById(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O visitante com ID " + id + " não foi encontrado.");
        }

        visitanteRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<?> atualizarVisitante(Long visitanteId, String nome, String telefone) {
        if (!visitanteRepository.existsById(visitanteId)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Visitante com ID " + visitanteId + " não encontrado.");
        }

        visitanteRepository.updateVisitante(visitanteId, nome, telefone);

        return ResponseEntity.ok(visitanteRepository.findById(visitanteId));
    }
}
