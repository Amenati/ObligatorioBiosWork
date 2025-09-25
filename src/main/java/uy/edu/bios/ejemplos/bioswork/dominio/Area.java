package uy.edu.bios.ejemplos.bioswork.dominio;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Area {

    @NotNull
    private long id;
    
    @NotBlank
    @Size(max = 100)
    private String nombre;
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Area() { }

    public Area(long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    
    
}
