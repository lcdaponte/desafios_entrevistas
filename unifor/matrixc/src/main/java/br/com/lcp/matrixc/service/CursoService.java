package br.com.lcp.matrixc.service;

import br.com.lcp.matrixc.model.Curso;
import br.com.lcp.matrixc.repository.CursoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public Curso inserir(Curso curso){
        return cursoRepository.save(curso);
    }

    public void deletar(Long id){
        cursoRepository.deleteById(id);
    }

    public Curso atualizar(Long id, Curso curso) {
        Optional<Curso> cursoSalvo = cursoRepository.findById(id);
        if(!cursoSalvo.isPresent()){
            throw new EmptyResultDataAccessException(1);
        }

        BeanUtils.copyProperties(curso, cursoSalvo.get(), "id");
        return cursoRepository.save(cursoSalvo.get());

    }
}
