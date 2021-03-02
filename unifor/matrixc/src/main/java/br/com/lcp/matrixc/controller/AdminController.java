package br.com.lcp.matrixc.controller;

import br.com.lcp.matrixc.model.Admin;
import br.com.lcp.matrixc.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;


    @GetMapping
    public ResponseEntity<List<Admin>> listarTodos() {
        return ResponseEntity.ok(adminService.listarTodos());
    }

    @PostMapping
    public ResponseEntity<Admin> inserir(@RequestBody Admin admin, HttpServletResponse response) {
        Admin adminSalvo = adminService.inserir(admin);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(adminSalvo.getId()).toUri();

        return ResponseEntity.created(uri).body(adminSalvo);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id){
        adminService.deletar(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Admin> atualizar(@PathVariable Long id, @RequestBody Admin admin){
        Admin adminAtualizado = adminService.atualizar(id, admin);

        return ResponseEntity.ok(adminAtualizado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Admin> buscarAdminPorId(@PathVariable Long id) {
        return ResponseEntity.ok(adminService.buscarAdminPorId(id));
    }


}
