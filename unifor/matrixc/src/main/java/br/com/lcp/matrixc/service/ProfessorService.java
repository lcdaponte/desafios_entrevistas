package br.com.lcp.matrixc.service;

import br.com.lcp.matrixc.model.Professor;
import br.com.lcp.matrixc.repository.ProfessorRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    public List<Professor> listarTodos() {
        return professorRepository.findAll();
    }

    public Professor inserir(Professor professor){
        return professorRepository.save(professor);
    }

    public void deletar(Long id){
        professorRepository.deleteById(id);
    }

    public Professor atualizar(Long id, Professor professor) {
        Optional<Professor> professorSalvo = professorRepository.findById(id);
        if(!professorSalvo.isPresent()){
            throw new EmptyResultDataAccessException(1);
        }

        BeanUtils.copyProperties(professor, professorSalvo.get(), "id");
        return professorRepository.save(professorSalvo.get());

    }

    public Professor buscarProfessorPorId(Long id) {
        Optional<Professor> professorSalvo = professorRepository.findById(id);
        if(!professorSalvo.isPresent()){
            throw new EmptyResultDataAccessException(1);
        }

        return professorSalvo.get();
    }
}
