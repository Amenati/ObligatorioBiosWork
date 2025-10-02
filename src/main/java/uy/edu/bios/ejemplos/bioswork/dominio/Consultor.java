package uy.edu.bios.ejemplos.bioswork.dominio;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "consultores")
@PrimaryKeyJoinColumn(name = "nombreUsuario", referencedColumnName = "nombreUsuario")
public class Consultor extends Usuario{

    public Consultor() {}
    
    public Consultor(String nombreUsuario,String contraseña) {
        super(nombreUsuario, contraseña);
    }
}
