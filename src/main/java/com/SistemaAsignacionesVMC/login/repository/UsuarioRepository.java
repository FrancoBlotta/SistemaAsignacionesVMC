
package com.SistemaAsignacionesVMC.login.repository;

import com.SistemaAsignacionesVMC.login.entity.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    
    public Optional<Usuario> findByemail(String email);
    
}
