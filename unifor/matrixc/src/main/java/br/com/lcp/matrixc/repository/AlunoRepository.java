package br.com.lcp.matrixc.repository;

import br.com.lcp.matrixc.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
