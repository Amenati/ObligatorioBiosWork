package uy.edu.bios.ejemplos.bioswork.modelos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {
    
    @NotBlank
    @Size(min = 3, max = 20, message = "El nombre debe tener entre 3 y 20 caracteres")
    public String nombreUsuario;

    @NotBlank
    @Size(min = 4, message = "La contraseña debe tener un minimo de 4 caracteres")
    public String contraseña;



    public String getNombreUsuario(){
        return nombreUsuario;
    }

     public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public Usuario(String nombreUsuario,String contraseña){
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
    }
}
