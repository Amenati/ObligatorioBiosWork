package uy.edu.bios.ejemplos.bioswork.dominio;

import java.sql.Date;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

public class Postulacion {

    @NotNull
    @PastOrPresent
    private Date fechaPostulacion;

    @NotNull
    private OfertaTrabajo ofertaTrabajo;

    @NotNull
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
