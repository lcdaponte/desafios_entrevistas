package br.com.lcp.matrixc.controller;

import br.com.lcp.matrixc.model.Professor;
import br.com.lcp.matrixc.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;


    @GetMapping
    public ResponseEntity<List<Professor>> listarTodos() {
        return ResponseEntity.ok(professorService.listarTodos());
    }

    @PostMapping
    public ResponseEntity<Professor> inserir(@RequestBody Professor professor, HttpServletResponse response) {
        Professor professorSalvo = professorService.inserir(professor);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(professorSalvo.getId()).toUri();

        return ResponseEntity.created(uri).body(professorSalvo);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id){
        professorService.deletar(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Professor> atualizar(@PathVariable Long id, @RequestBody Professor professor){
        Professor professorAtualizado = professorService.atualizar(id, professor);

        return ResponseEntity.ok(professorAtualizado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Professor> buscarProfessorPorId(@PathVariable Long id) {
        return ResponseEntity.ok(professorService.buscarProfessorPorId(id));
    }


}
