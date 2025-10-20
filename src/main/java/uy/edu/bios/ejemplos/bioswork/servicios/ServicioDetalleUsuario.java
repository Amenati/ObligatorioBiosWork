package uy.edu.bios.ejemplos.bioswork.servicios;

import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import uy.edu.bios.ejemplos.bioswork.modelos.Rol;
import uy.edu.bios.ejemplos.bioswork.modelos.Usuario;
import uy.edu.bios.ejemplos.bioswork.repositorios.IRepositorioUsuario;
import uy.edu.bios.ejemplos.bioswork.servicios.interfaces.IServicioDetalleUsuario;

@Service
public class ServicioDetalleUsuario implements UserDetailsService, IServicioDetalleUsuario{

    @Autowired
    public IRepositorioUsuario repositorioUsuario;



    @Override
    public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {

       Usuario usuario = repositorioUsuario.findById(nombreUsuario).orElse(null);

       if(usuario == null || !usuario.isActivo()){
        throw new UnsupportedOperationException("el usuario no existe."); 
       }

       Set<GrantedAuthority> roles = new HashSet<>();

       for(Rol r : usuario.getRol()){
        roles.add(new SimpleGrantedAuthority(r.getNombreRol().name()));
       }

       return new User(usuario.getNombreUsuario(), usuario.getContraseña(),usuario.isActivo(),true,true,true,roles);      
    } 
}
