package br.com.fullstack.moduloumsemananove.service;

import br.com.fullstack.moduloumsemananove.model.Bibliotecario;
import br.com.fullstack.moduloumsemananove.repository.BibliotecarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BibliotecarioService {

    @Autowired
    BibliotecarioRepository bibliotecarioRepository;

    public Bibliotecario criarBibliotecario(Bibliotecario bibliotecario){
        return bibliotecarioRepository.save(bibliotecario);
    }

    public List<Bibliotecario> listarBibliotecario(){
        return bibliotecarioRepository.findAll();
    }

    public ResponseEntity<?> deletarBibliotecario(Long id) {
        if(!bibliotecarioRepository.existsById(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O bibliotecario com ID " + id + " não foi encontrado.");
        }

        bibliotecarioRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
