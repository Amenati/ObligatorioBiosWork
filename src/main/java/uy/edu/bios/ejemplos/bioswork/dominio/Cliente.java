package uy.edu.bios.ejemplos.bioswork.dominio;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "clientes")
@PrimaryKeyJoinColumn(name = "nombreUsuario", referencedColumnName = "nombreUsuario")
public class Cliente extends Usuario{

    @NotBlank
    @Size(min = 12, max = 12)
    @Column(nullable = false, length = 12)
    private String rut;

    @NotBlank
    @Size(max = 30)
    @Column(nullable = false, length = 30)
    private String nombre;
    
    @Size(max = 50)
    @Column(length = 12)
    private String url;



    public String getRut(){
        return rut;
    }

     public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getUrl(){
        return url;
    }

    public void setUrl(String url){
        this.url = url;
    }
    

    public Cliente() {}

     
    public Cliente(String nombreUsuario,String contraseña, String rut, String nombre, String url) {
        super(nombreUsuario, contraseña);
        this.rut = rut;
        this.nombre = nombre;
        this.url = url;
    }
}