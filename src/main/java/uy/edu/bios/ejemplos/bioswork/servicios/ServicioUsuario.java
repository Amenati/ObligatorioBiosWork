package uy.edu.bios.ejemplos.bioswork.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uy.edu.bios.ejemplos.bioswork.modelos.Rol;
import uy.edu.bios.ejemplos.bioswork.modelos.Usuario;
import uy.edu.bios.ejemplos.bioswork.modelos.enums.NombreRol;
import uy.edu.bios.ejemplos.bioswork.repositorios.RepositorioRol;
import uy.edu.bios.ejemplos.bioswork.repositorios.RepositorioUsuario;

@Service
public class ServicioUsuario {

    @Autowired
    private RepositorioUsuario usuarioRepository;

    @Autowired
    public RepositorioRol rolRepository;

    public void registrarPostulante(Usuario usuario) {
        // Rol rolPostulante = rolRepository.findByNombre(String.valueOf(NombreRol.POSTULANTE));
        // usuario.setRol(rolPostulante);
        // usuarioRepository.save(usuario);
    }

    public void registrarCliente(Usuario usuario) {
        // Rol rolCliente = rolRepository.findByNombre(String.valueOf(NombreRol.CLIENTE));
        // usuario.setRol(rolCliente);
        // usuarioRepository.save(usuario);
    }
}
    

