package uy.edu.bios.ejemplos.bioswork.dominio;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ofertas_trabajo")
public class OfertaTrabajo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private long id;

    @NotNull
    @PastOrPresent 
    @Column(nullable = false) 
    private LocalDateTime fechaPublicacion;

    @NotNull
    @FutureOrPresent
    @Column(nullable = false)
    private LocalDateTime fechaCierre;

    @NotBlank
    @Size(max = 100)
    @Column(nullable = false, length = 100)
    private String titulo;

    @NotBlank
    @Column(nullable = false, length = 1000)
    private String descripcion;

    @NotNull
    @Min(value = 1)
    @Column(nullable = false)
    private Integer puestosVacantes;

    @NotNull
    @ManyToOne(optional = false)
    private Area area;

    @NotNull
    @ManyToOne(optional = false)
    private Cliente cliente;




    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(LocalDateTime fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public LocalDateTime getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(LocalDateTime fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getPuestosVacantes() {
        return puestosVacantes;
    }

    public void setPuestosVacantes(Integer puestosVacantes) {
        this.puestosVacantes = puestosVacantes;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }




    
    public OfertaTrabajo() {}
    

    public OfertaTrabajo(long id, LocalDateTime fechaPublicacion, LocalDateTime fechaCierre, String titulo, String descripcion, Integer puestosVacantes, Area area, Cliente cliente) {
        this.id = id;
        this.fechaPublicacion = fechaPublicacion;
        this.fechaCierre = fechaCierre;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.puestosVacantes = puestosVacantes;
        this.area = area;
        this.cliente = cliente;

    }







}