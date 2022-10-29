
package com.porfolioArgPro.mch.Security.Repository;

import com.porfolioArgPro.mch.Security.Entity.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iUsuarioRepository extends JpaRepository<Usuario, Integer>{
    Optional<Usuario> findByNombreUsuario(String nombreUsuario);
    
    //Nos devuelve verdadero o falso en caso de que encuentre nombre o usuario
    boolean existsByNombreUsuario(String nombreUsuario);
    boolean existsByEmail(String email);
}
