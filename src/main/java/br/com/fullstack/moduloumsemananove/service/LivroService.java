package br.com.fullstack.moduloumsemananove.service;

import br.com.fullstack.moduloumsemananove.model.Livro;
import br.com.fullstack.moduloumsemananove.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public Livro criarLivro(Livro livro) {
        return livroRepository.save(livro);
    }

    public List<Livro> listarLivro(){
        return livroRepository.findAll();
    }
}
