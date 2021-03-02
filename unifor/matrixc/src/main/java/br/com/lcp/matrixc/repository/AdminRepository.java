package br.com.lcp.matrixc.repository;

import br.com.lcp.matrixc.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}
