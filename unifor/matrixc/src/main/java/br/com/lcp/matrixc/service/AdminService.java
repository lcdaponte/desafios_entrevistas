package br.com.lcp.matrixc.service;

import br.com.lcp.matrixc.model.Admin;
import br.com.lcp.matrixc.repository.AdminRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> listarTodos() {
        return adminRepository.findAll();
    }

    public Admin inserir(Admin admin){
        return adminRepository.save(admin);
    }

    public void deletar(Long id){
        adminRepository.deleteById(id);
    }

    public Admin atualizar(Long id, Admin admin) {
        Optional<Admin> adminSalvo = adminRepository.findById(id);
        if(!adminSalvo.isPresent()){
            throw new EmptyResultDataAccessException(1);
        }

        BeanUtils.copyProperties(admin, adminSalvo.get(), "id");
        return adminRepository.save(adminSalvo.get());

    }

    public Admin buscarAdminPorId(Long id) {
        Optional<Admin> adminSalvo = adminRepository.findById(id);
        if(!adminSalvo.isPresent()){
            throw new EmptyResultDataAccessException(1);
        }

        return adminSalvo.get();
    }
}
