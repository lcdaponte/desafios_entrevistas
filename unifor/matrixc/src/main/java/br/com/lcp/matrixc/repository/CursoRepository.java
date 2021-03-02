package br.com.lcp.matrixc.repository;

import br.com.lcp.matrixc.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}
