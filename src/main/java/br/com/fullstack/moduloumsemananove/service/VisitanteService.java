package br.com.fullstack.moduloumsemananove.service;

import br.com.fullstack.moduloumsemananove.model.Visitante;
import br.com.fullstack.moduloumsemananove.repository.VisitanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VisitanteService {

    @Autowired
    VisitanteRepository visitanteRepository;

    public Visitante criarVisitante(Visitante visitante){
        return visitanteRepository.save(visitante);
    }
}
