package br.com.lcp.matrixc.controller;

import br.com.lcp.matrixc.model.MatrizCurricular;
import br.com.lcp.matrixc.service.MatrizCurricularService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/matrizCurricular")
public class MatrizCurricularController {

    @Autowired
    private MatrizCurricularService matrizCurricularService;


    @GetMapping
    public ResponseEntity<List<MatrizCurricular>> listarTodos() {
        return ResponseEntity.ok(matrizCurricularService.listarTodos());
    }

    @PostMapping
    public ResponseEntity<MatrizCurricular> inserir(@RequestBody MatrizCurricular matrizCurricular, HttpServletResponse response) {
        MatrizCurricular matrizCurricularSalvo = matrizCurricularService.inserir(matrizCurricular);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(matrizCurricularSalvo.getId()).toUri();

        return ResponseEntity.created(uri).body(matrizCurricularSalvo);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id){
        matrizCurricularService.deletar(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MatrizCurricular> atualizar(@PathVariable Long id, @RequestBody MatrizCurricular matrizCurricular){
        MatrizCurricular matrizCurricularAtualizado = matrizCurricularService.atualizar(id, matrizCurricular);

        return ResponseEntity.ok(matrizCurricularAtualizado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MatrizCurricular> buscarMatrizCurricularPorId(@PathVariable Long id) {
        return ResponseEntity.ok(matrizCurricularService.buscarMatrizCurricularPorId(id));
    }


}
