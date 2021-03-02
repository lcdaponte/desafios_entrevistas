package br.com.lcp.matrixc.service;

import br.com.lcp.matrixc.model.Aluno;
import br.com.lcp.matrixc.repository.AlunoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public List<Aluno> listarTodos() {
        return alunoRepository.findAll();
    }

    public Aluno inserir(Aluno aluno){
        return alunoRepository.save(aluno);
    }

    public void deletar(Long id){
        alunoRepository.deleteById(id);
    }

    public Aluno atualizar(Long alunoId, Aluno aluno) {
        Optional<Aluno> alunoSalvo = alunoRepository.findById(alunoId);
        if(!alunoSalvo.isPresent()){
            throw new EmptyResultDataAccessException(1);
        }

        BeanUtils.copyProperties(aluno, alunoSalvo.get(), "id");
        return alunoRepository.save(alunoSalvo.get());

    }

    public Aluno buscarAlunoPorId(Long alunoId) {
        Optional<Aluno> alunoSalvo = alunoRepository.findById(alunoId);
        if(!alunoSalvo.isPresent()){
            throw new EmptyResultDataAccessException(1);
        }

        return alunoSalvo.get();
    }
}
