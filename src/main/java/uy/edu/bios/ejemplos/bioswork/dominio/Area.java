package uy.edu.bios.ejemplos.bioswork.dominio;

public class Area {

    private long id;
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

    public Area() {}

    public Area(long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    
    
}
