package br.com.lcp.matrixc.service;

import br.com.lcp.matrixc.model.Semestre;
import br.com.lcp.matrixc.model.Semestre;
import br.com.lcp.matrixc.repository.SemestreRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SemestreService {

    @Autowired
    private SemestreRepository semestreRepository;

    public List<Semestre> listarTodos() {
        return semestreRepository.findAll();
    }

    public Semestre inserir(Semestre semestre){
        return semestreRepository.save(semestre);
    }

    public void deletar(Long id){
        semestreRepository.deleteById(id);
    }

    public Semestre atualizar(Long id, Semestre semestre) {
        Optional<Semestre> semestreSalvo = semestreRepository.findById(id);
        if(!semestreSalvo.isPresent()){
            throw new EmptyResultDataAccessException(1);
        }

        BeanUtils.copyProperties(semestre, semestreSalvo.get(), "id");
        return semestreRepository.save(semestreSalvo.get());

    }

    public Semestre buscarSemestrePorId(Long id) {
        Optional<Semestre> semestreSalvo = semestreRepository.findById(id);
        if(!semestreSalvo.isPresent()){
            throw new EmptyResultDataAccessException(1);
        }

        return semestreSalvo.get();
    }
}
