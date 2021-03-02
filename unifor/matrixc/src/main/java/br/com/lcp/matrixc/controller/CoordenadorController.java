package br.com.lcp.matrixc.controller;

import br.com.lcp.matrixc.model.Coordenador;
import br.com.lcp.matrixc.service.CoordenadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/coordenador")
public class CoordenadorController {

    @Autowired
    private CoordenadorService coordenadorService;


    @GetMapping
    public ResponseEntity<List<Coordenador>> listarTodos() {
        return ResponseEntity.ok(coordenadorService.listarTodos());
    }

    @PostMapping
    public ResponseEntity<Coordenador> inserir(@RequestBody Coordenador coordenador, HttpServletResponse response) {
        Coordenador coordenadorSalvo = coordenadorService.inserir(coordenador);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(coordenadorSalvo.getId()).toUri();

        return ResponseEntity.created(uri).body(coordenadorSalvo);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id){
        coordenadorService.deletar(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Coordenador> atualizar(@PathVariable Long id, @RequestBody Coordenador coordenador){
        Coordenador coordenadorAtualizado = coordenadorService.atualizar(id, coordenador);

        return ResponseEntity.ok(coordenadorAtualizado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Coordenador> buscarCoordenadorPorId(@PathVariable Long id) {
        return ResponseEntity.ok(coordenadorService.buscarCoordenadorPorId(id));
    }


}
