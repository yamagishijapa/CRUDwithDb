package br.com.fullstack.moduloumsemananove.service;

import br.com.fullstack.moduloumsemananove.model.Bibliotecario;
import br.com.fullstack.moduloumsemananove.repository.BibliotecarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
}
