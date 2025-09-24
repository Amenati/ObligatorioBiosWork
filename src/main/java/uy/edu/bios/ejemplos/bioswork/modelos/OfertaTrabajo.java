package uy.edu.bios.ejemplos.bioswork.modelos;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "ofertaTrabajos")
public class OfertaTrabajo {
    
    @NotNull
    public String id;
    public LocalDateTime fechaPublicacion;
    public LocalDateTime fechaCierre;
    public String titulo;
    public String descripcionDetallada;
    public Integer puestosVacantes;

}
