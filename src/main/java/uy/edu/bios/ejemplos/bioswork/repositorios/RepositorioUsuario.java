package uy.edu.bios.ejemplos.bioswork.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uy.edu.bios.ejemplos.bioswork.modelos.Usuario;

@Repository
public interface RepositorioUsuario extends JpaRepository<Usuario,String>{

   // Optional<Usuario> findByNombreUsuario(String nombreUsuario);
    
}
