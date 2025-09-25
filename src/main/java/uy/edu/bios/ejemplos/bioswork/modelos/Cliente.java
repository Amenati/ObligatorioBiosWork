package uy.edu.bios.ejemplos.bioswork.modelos;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @NotBlank
    @Size(max = 30)
    public String rut;

    @NotBlank
    @Size(max = 30)
    public String nombre;
            
    public String urlWeb;



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

     
    public Cliente(@NotBlank @Size(max = 30) String rut, @NotBlank @Size(max = 30) String nombre, String urlWeb) {
        this.rut = rut;
        this.nombre = nombre;
        this.urlWeb = urlWeb;
    }
}
