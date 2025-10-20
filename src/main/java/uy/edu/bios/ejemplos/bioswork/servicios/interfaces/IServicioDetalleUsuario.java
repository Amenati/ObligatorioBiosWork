package uy.edu.bios.ejemplos.bioswork.servicios.interfaces;

import org.springframework.security.core.userdetails.UserDetails;


public interface IServicioDetalleUsuario {


    UserDetails loadUserByUsername(String nombreUsuario);

}
