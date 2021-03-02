package br.com.lcp.matrixc.controller;

import br.com.lcp.matrixc.model.Semestre;
import br.com.lcp.matrixc.service.SemestreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/semestre")
public class SemestreController {

    @Autowired
    private SemestreService semestreService;


    @GetMapping
    public ResponseEntity<List<Semestre>> listarTodos() {
        return ResponseEntity.ok(semestreService.listarTodos());
    }

    @PostMapping
    public ResponseEntity<Semestre> inserir(@RequestBody Semestre semestre, HttpServletResponse response) {
        Semestre semestreSalvo = semestreService.inserir(semestre);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(semestreSalvo.getId()).toUri();

        return ResponseEntity.created(uri).body(semestreSalvo);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id){
        semestreService.deletar(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Semestre> atualizar(@PathVariable Long id, @RequestBody Semestre semestre){
        Semestre semestreAtualizado = semestreService.atualizar(id, semestre);

        return ResponseEntity.ok(semestreAtualizado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Semestre> buscarSemestrePorId(@PathVariable Long id) {
        return ResponseEntity.ok(semestreService.buscarSemestrePorId(id));
    }


}
