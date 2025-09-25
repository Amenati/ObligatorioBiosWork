package uy.edu.bios.ejemplos.bioswork.dominio;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

//import jakarta.persistence.Entity;
//import jakarta.persistence.Table;

//@Entity
//@Table(name = "postulantes")
public class Postulante extends Usuario{
        
   @NotBlank
   @Size(min = 7, max=8)
   private String cedula;

   @NotBlank
   @Size(max = 50)
   private String nombreCompleto;
            
   @NotBlank
   @Past
   private LocalDate fechaNacimiento;

   @NotBlank
   @Size(max = 30)
   private String departamentoResidencia;

   //@Size(max = 2048576, message = "La imagen no puede superar 2 MB")
   private Byte[] foto; 

   @NotNull
   //@Size(max = 5048576, message = "El CV no puede superar 5 MB")
   private Byte[] curriculum;

   private boolean tieneImagen;

   private boolean tieneCurriculum;  
   
   

   


   public String getCedula() {
      return cedula;
   }


   public void setCedula(String cedula) {
      this.cedula = cedula;
   }


   public String getNombreCompleto() {
      return nombreCompleto;
   }


   public void setNombreCompleto(String nombreCompleto) {
      this.nombreCompleto = nombreCompleto;
   }


   public LocalDate getFechaNacimiento() {
      return fechaNacimiento;
   }


   public void setFechaNacimiento(LocalDate fechaNacimiento) {
      this.fechaNacimiento = fechaNacimiento;
   }


   public String getDepartamentoResidencia() {
      return departamentoResidencia;
   }


   public void setDepartamentoResidencia(String departamentoResidencia) {
      this.departamentoResidencia = departamentoResidencia;
   }


   public Byte[] getFoto() {
      return foto;
   }


   public void setFoto(Byte[] foto) {
      this.foto = foto;
   }


   public Byte[] getCurriculum() {
      return curriculum;
   }


   public void setCurriculum(Byte[] curriculum) {
      this.curriculum = curriculum;
   }


   public boolean isTieneImagen() {
      return tieneImagen;
   }


   public void setTieneImagen(boolean tieneImagen) {
      this.tieneImagen = tieneImagen;
   }


   public boolean isTieneCurriculum() {
      return tieneCurriculum;
   }


   public void setTieneCurriculum(boolean tieneCurriculum) {
      this.tieneCurriculum = tieneCurriculum;
   }



   public Postulante() {}

   public Postulante(String nombreUsuario, String contraseña, String cedula, String nombreCompleto, LocalDate fechaNacimiento, String departamentoResidencia, Byte[] foto, Byte[] curriculum, boolean tieneImagen, boolean tieneCurriculum) {
      super(nombreUsuario, contraseña);
      this.cedula = cedula;
      this.nombreCompleto = nombreCompleto;
      this.fechaNacimiento = fechaNacimiento;
      this.departamentoResidencia = departamentoResidencia;
      this.foto = foto;
      this.curriculum = curriculum;
      this.tieneImagen = tieneImagen;
      this.tieneCurriculum = tieneCurriculum;
   } 


}