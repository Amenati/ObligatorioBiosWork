package uy.edu.bios.ejemplos.bioswork.dominio;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
@Inheritance(strategy = InheritanceType.JOINED)
class Usuario {
    
    @Id
    @NotBlank
    @Size(min = 3, max = 20)
    @Column(length = 20)
    private String nombreUsuario;

    @NotBlank
    @Size(min = 4)
    @Column(nullable = false, length = 50)
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