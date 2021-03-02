package br.com.lcp.matrixc.repository;

import br.com.lcp.matrixc.model.Semestre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SemestreRepository extends JpaRepository<Semestre, Long> {
}
