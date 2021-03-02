package br.com.lcp.matrixc.service;

import br.com.lcp.matrixc.model.Coordenador;
import br.com.lcp.matrixc.repository.CoordenadorRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoordenadorService {

    @Autowired
    private CoordenadorRepository coordenadorRepository;

    public List<Coordenador> listarTodos() {
        return coordenadorRepository.findAll();
    }

    public Coordenador inserir(Coordenador coordenador){
        return coordenadorRepository.save(coordenador);
    }

    public void deletar(Long id){
        coordenadorRepository.deleteById(id);
    }

    public Coordenador atualizar(Long id, Coordenador coordenador) {
        Optional<Coordenador> coordenadorSalvo = coordenadorRepository.findById(id);
        if(!coordenadorSalvo.isPresent()){
            throw new EmptyResultDataAccessException(1);
        }

        BeanUtils.copyProperties(coordenador, coordenadorSalvo.get(), "id");
        return coordenadorRepository.save(coordenadorSalvo.get());

    }

    public Coordenador buscarCoordenadorPorId(Long id) {
        Optional<Coordenador> coordenadorSalvo = coordenadorRepository.findById(id);
        if(!coordenadorSalvo.isPresent()){
            throw new EmptyResultDataAccessException(1);
        }

        return coordenadorSalvo.get();
    }
}
