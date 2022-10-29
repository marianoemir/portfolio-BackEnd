package com.porfolioArgPro.mch.Security.Service;

import com.porfolioArgPro.mch.Security.Entity.Usuario;
import com.porfolioArgPro.mch.Security.Repository.iUsuarioRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional   
public class UsuarioService {
    @Autowired
    iUsuarioRepository iusuarioRepository;
    
    public Optional<Usuario> getByNombreUsuario(String nombreUsuario){
        return iusuarioRepository.findByNombreUsuario(nombreUsuario);
    }
    //Chequea si el nombre de usuario existe
    public boolean existsByNombreUsuario (String nombreUsuario){
        return iusuarioRepository.existsByNombreUsuario(nombreUsuario);
    }
    //Chequea si el email existe
    public boolean existsByEmail (String email){
        return iusuarioRepository.existsByNombreUsuario(email);
    }
    //Guarda un usuario nuevo
    public void save(Usuario usuario){
        iusuarioRepository.save(usuario);
    }
}
