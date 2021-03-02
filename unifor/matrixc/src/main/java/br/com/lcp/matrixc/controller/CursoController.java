package br.com.lcp.matrixc.controller;

import br.com.lcp.matrixc.model.Curso;
import br.com.lcp.matrixc.service.CursoService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;

@RestController
@RequestMapping("/curso")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @PostMapping
    public ResponseEntity<Curso> inserir(@RequestBody Curso curso, HttpServletResponse response) {
        Curso cursoSalvo = cursoService.inserir(curso);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(cursoSalvo.getId()).toUri();

        return ResponseEntity.created(uri).body(cursoSalvo);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id){
        cursoService.deletar(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Curso> atualizar(@PathVariable Long id, @RequestBody Curso curso){
        Curso cursoAtualizado = cursoService.atualizar(id, curso);

        return ResponseEntity.ok(cursoAtualizado);
    }


}
