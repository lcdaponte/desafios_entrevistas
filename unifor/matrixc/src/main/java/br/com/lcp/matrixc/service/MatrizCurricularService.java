package br.com.lcp.matrixc.service;

import br.com.lcp.matrixc.model.MatrizCurricular;
import br.com.lcp.matrixc.repository.MatrizCurricularRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatrizCurricularService {

    @Autowired
    private MatrizCurricularRepository matrizCurricularRepository;

    public List<MatrizCurricular> listarTodos() {
        return matrizCurricularRepository.findAll();
    }

    public MatrizCurricular inserir(MatrizCurricular matrizCurricular){
        return matrizCurricularRepository.save(matrizCurricular);
    }

    public void deletar(Long id){
        matrizCurricularRepository.deleteById(id);
    }

    public MatrizCurricular atualizar(Long id, MatrizCurricular matrizCurricular) {
        Optional<MatrizCurricular> matrizCurricularSalvo = matrizCurricularRepository.findById(id);
        if(!matrizCurricularSalvo.isPresent()){
            throw new EmptyResultDataAccessException(1);
        }

        BeanUtils.copyProperties(matrizCurricular, matrizCurricularSalvo.get(), "id");
        return matrizCurricularRepository.save(matrizCurricularSalvo.get());

    }

    public MatrizCurricular buscarMatrizCurricularPorId(Long id) {
        Optional<MatrizCurricular> matrizCurricularSalvo = matrizCurricularRepository.findById(id);
        if(!matrizCurricularSalvo.isPresent()){
            throw new EmptyResultDataAccessException(1);
        }

        return matrizCurricularSalvo.get();
    }
}
