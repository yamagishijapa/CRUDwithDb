package br.com.fullstack.moduloumsemananove.service;

import br.com.fullstack.moduloumsemananove.model.Emprestimo;
import br.com.fullstack.moduloumsemananove.model.Livro;
import br.com.fullstack.moduloumsemananove.model.Membro;
import br.com.fullstack.moduloumsemananove.repository.EmprestimoRepository;
import br.com.fullstack.moduloumsemananove.repository.LivroRepository;
import br.com.fullstack.moduloumsemananove.repository.MembroRepository;
import br.com.fullstack.moduloumsemananove.request.EmprestimoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class EmprestimoService {

    @Autowired
    EmprestimoRepository emprestimoRepository;

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private MembroRepository membroRepository;

    public Emprestimo criarEmprestimo(EmprestimoRequest emprestimoRequest){
        Emprestimo emprestimo = validaEmprestimo(emprestimoRequest);
        return emprestimoRepository.save(emprestimo);
    }

    public List<Emprestimo> listarEmprestimo(){
        return emprestimoRepository.findAll();
    }

    private Emprestimo validaEmprestimo(EmprestimoRequest emprestimoRequest){
        if (!livroRepository.existsById(emprestimoRequest.getLivroId())) {
            throw new NoSuchElementException("Livro não encontrado com ID: " + emprestimoRequest.getLivroId());
        }
        Optional<Livro> livro = livroRepository.findById(emprestimoRequest.getLivroId());

        if (!membroRepository.existsById(emprestimoRequest.getMembroId())) {
            throw new NoSuchElementException("Membro não encontrado com ID: " + emprestimoRequest.getMembroId());
        }
        Optional<Membro> membro = membroRepository.findById(emprestimoRequest.getMembroId());

        return mapDtoToEntity(emprestimoRequest, livro.get(), membro.get());
    }

    private Emprestimo mapDtoToEntity(EmprestimoRequest emprestimoRequest, Livro livro, Membro membro){
        return new Emprestimo(livro, membro,
                emprestimoRequest.getDataEmprestimo(),
                emprestimoRequest.getDataDevolucao());
    }
}
