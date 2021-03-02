package br.com.lcp.matrixc.controller;

import br.com.lcp.matrixc.model.Disciplina;
import br.com.lcp.matrixc.service.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/disciplina")
public class DisciplinaController {


    @Autowired
    private DisciplinaService disciplinaService;


    @GetMapping
    public ResponseEntity<List<Disciplina>> listarTodos() {
        return ResponseEntity.ok(disciplinaService.listarTodos());
    }

    @PostMapping
    public ResponseEntity<Disciplina> inserir(@RequestBody Disciplina disciplina, HttpServletResponse response) {
        Disciplina disciplinaSalvo = disciplinaService.inserir(disciplina);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(disciplinaSalvo.getId()).toUri();

        return ResponseEntity.created(uri).body(disciplinaSalvo);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id){
        disciplinaService.deletar(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Disciplina> atualizar(@PathVariable Long id, @RequestBody Disciplina disciplina){
        Disciplina disciplinaAtualizado = disciplinaService.atualizar(id, disciplina);

        return ResponseEntity.ok(disciplinaAtualizado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Disciplina> buscarDisciplinaPorId(@PathVariable Long id) {
        return ResponseEntity.ok(disciplinaService.buscarDisciplinaPorId(id));
    }


}
