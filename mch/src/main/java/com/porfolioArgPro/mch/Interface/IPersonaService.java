
package com.porfolioArgPro.mch.Interface;

import com.porfolioArgPro.mch.Entity.Persona;
import java.util.List;



public interface IPersonaService {
    //Traer una lista de Personas
    public List<Persona> getPersona();
    
    //Guardar un Obj de tipo Persona
    public void savePersona(Persona persona);
    
    //Eliminar un usuario lo buscamos por ID
    public void deletePersona(Long id);
    
    //Buscar Persona por ID
    public Persona findPersona(Long id);
    
    
}
