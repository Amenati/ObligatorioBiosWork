package uy.edu.bios.ejemplos.bioswork.modelos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {
    
    @Id
    @NotBlank
    @Size(min = 3, max = 20, message = "El nombre debe tener entre 3 y 20 caracteres")
    public String nombreUsuario;

    @NotBlank
    @Size(min = 4, message = "La contraseña debe tener un minimo de 4 caracteres")
    public String contraseña;

    @ManyToMany
    @JoinTable(joinColumns = { @JoinColumn(name = "usuario_nombre_usuario") }, inverseJoinColumns = { @JoinColumn(name = "rol_nombre_rol") })
    public Set<Rol> rol;

    private boolean activo;


    public String getNombreUsuario(){
        return nombreUsuario;
    }

     public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public boolean isActivo() {
    return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Usuario(){

    }

        public Usuario(String nombreUsuario,String contraseña,Set<Rol> rol,boolean activo){
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
        this.rol = rol;
        this.activo = activo;
    }

        public Set<Rol> getRol() {
            return this.rol;
        }
}
