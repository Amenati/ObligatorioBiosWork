package uy.edu.bios.ejemplos.bioswork.dominio;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

@Entity
@Table(name = "postulaciones")
public class Postulacion {

    @NotNull
    @PastOrPresent
    @Column(nullable = false)
    private Date fechaPostulacion;

    @Id
    @NotNull
    @ManyToOne(optional = false)
    private OfertaTrabajo ofertaTrabajo;

    @NotNull
    @ManyToOne(optional = false)
    private Postulante postulante;




    public Date getFechaPostulacion() {
        return fechaPostulacion;
    }

    public void setFechaPostulacion(Date fechaPostulacion) {
        this.fechaPostulacion = fechaPostulacion;
    }

    public OfertaTrabajo getOfertaTrabajo() {
        return ofertaTrabajo;
    }

    public void setOfertaTrabajo(OfertaTrabajo ofertaTrabajo) {
        this.ofertaTrabajo = ofertaTrabajo;
    }

    public Postulante getPostulante() {
        return postulante;
    }

    public void setPostulante(Postulante postulante) {
        this.postulante = postulante;
    }



    public Postulacion() {}

    public Postulacion(Date fechaPostulacion, OfertaTrabajo ofertaTrabajo, Postulante postulante) {
        this.fechaPostulacion = fechaPostulacion;
        this.ofertaTrabajo = ofertaTrabajo;
        this.postulante = postulante;
    }   

    
    
}
