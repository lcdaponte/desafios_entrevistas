package br.com.lcp.matrixc.service;

import br.com.lcp.matrixc.model.Disciplina;
import br.com.lcp.matrixc.repository.DisciplinaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DisciplinaService {

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    public List<Disciplina> listarTodos() {
        return disciplinaRepository.findAll();
    }

    public Disciplina inserir(Disciplina disciplina){
        return disciplinaRepository.save(disciplina);
    }

    public void deletar(Long id){
        disciplinaRepository.deleteById(id);
    }

    public Disciplina atualizar(Long id, Disciplina disciplina) {
        Optional<Disciplina> disciplinaSalvo = disciplinaRepository.findById(id);
        if(!disciplinaSalvo.isPresent()){
            throw new EmptyResultDataAccessException(1);
        }

        BeanUtils.copyProperties(disciplina, disciplinaSalvo.get(), "id");
        return disciplinaRepository.save(disciplinaSalvo.get());

    }

    public Disciplina buscarDisciplinaPorId(Long id) {
        Optional<Disciplina> disciplinaSalvo = disciplinaRepository.findById(id);
        if(!disciplinaSalvo.isPresent()){
            throw new EmptyResultDataAccessException(1);
        }

        return disciplinaSalvo.get();
    }
}
