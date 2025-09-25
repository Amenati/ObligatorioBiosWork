package uy.edu.bios.ejemplos.bioswork.dominio;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
//import jakarta.persistence.Entity;
//import jakarta.persistence.Table;

//@Entity
//@Table(name = "usuarios")
class Usuario {
    
    @NotBlank
    @Size(min = 3, max = 20)
    private String nombreUsuario;

    @NotBlank
    @Size(min = 4)
    private String contrasena;


    public String getNombreUsuario(){
        return nombreUsuario;
    }

     public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Usuario() {}
    

    public Usuario(String nombreUsuario,String contrasena){
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
    }

    
}