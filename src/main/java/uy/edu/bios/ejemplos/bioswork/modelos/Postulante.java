package uy.edu.bios.ejemplos.bioswork.modelos;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "postulantes")
public class Postulante {
        
    @Id
    @NotBlank
    @Size(min = 6, max=8,message = "La cedula debe tener entre 6 y 8 digitos")
    public String cedula;

    @NotBlank
    @Size(max = 30)
    public String nombreCompleto;
            
    @NotBlank
    @Past(message = "La fecha de nacimiento debe estar en el pasado")
    public LocalDate fechaNacimiento;

    @NotBlank
    @Size(max = 30)
    public String departamentoResidencia;


    @Size(max = 2048576, message = "La imagen no puede superar 2 MB")
    public byte[] fotografia; 

    @Size(max = 5048576, message = "El CV no puede superar 5 MB")
    public byte[] curriculum;

    public boolean tieneImagen;

    public boolean tieneCurriculum;



     public Postulante(
            @NotBlank @Size(min = 6, max = 8, message = "La cedula debe tener entre 6 y 8 digitos") String cedula,
            @NotBlank @Size(max = 30) String nombreCompleto,
            @NotBlank @Past(message = "La fecha de nacimiento debe estar en el pasado") LocalDate fechaNacimiento,
            @NotBlank @Size(max = 30) String departamentoResidencia,
            @Size(max = 2048576, message = "La imagen no puede superar 2 MB") byte[] fotografia,
            @Size(max = 5048576, message = "El CV no puede superar 5 MB") byte[] curriculum) {
        this.cedula = cedula;
        this.nombreCompleto = nombreCompleto;
        this.fechaNacimiento = fechaNacimiento;
        this.departamentoResidencia = departamentoResidencia;
        this.fotografia = fotografia;
        this.curriculum = curriculum;
     } 


}