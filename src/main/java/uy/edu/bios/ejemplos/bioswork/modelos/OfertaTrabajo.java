package uy.edu.bios.ejemplos.bioswork.modelos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ofertaTrabajos")
public class OfertaTrabajo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @NotNull
    public LocalDateTime fechaPublicacion;

    @NotNull
    public LocalDateTime fechaCierre;

    @NotNull
    public String titulo;

    @NotNull
    @ManyToOne
    public Area area;

    @NotBlank
    public String descripcionDetallada;

    @NotNull
    public Integer puestosVacantes;

}
