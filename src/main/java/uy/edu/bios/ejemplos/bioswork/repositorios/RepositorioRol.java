package uy.edu.bios.ejemplos.bioswork.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uy.edu.bios.ejemplos.bioswork.modelos.Rol;
import uy.edu.bios.ejemplos.bioswork.modelos.enums.NombreRol;

@Repository
public interface RepositorioRol extends JpaRepository<Rol,Long>{

   // Rol findByNombre(String nombreRol);
}
