package br.com.lcp.matrixc.repository;

import br.com.lcp.matrixc.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}
