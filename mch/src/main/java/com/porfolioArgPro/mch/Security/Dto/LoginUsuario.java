
package com.porfolioArgPro.mch.Security.Dto;

import javax.validation.constraints.NotBlank;


public class LoginUsuario {
    //NotBlank Significa que no pueden estar vacios
    @NotBlank
    private String nombreUsuario;
    @NotBlank
    private String password;

    //Getter and Setter
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
