package br.com.fullstack.moduloumsemananove.service;

import br.com.fullstack.moduloumsemananove.model.Membro;
import br.com.fullstack.moduloumsemananove.repository.MembroRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
}
