
package com.porfolioArgPro.mch.Security.Repository;

import com.porfolioArgPro.mch.Security.Entity.Rol;
import com.porfolioArgPro.mch.Security.Enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iRolRepository extends JpaRepository<Rol, Integer>{
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
    
}
