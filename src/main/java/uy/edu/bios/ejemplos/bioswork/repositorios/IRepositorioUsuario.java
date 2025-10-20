package uy.edu.bios.ejemplos.bioswork.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uy.edu.bios.ejemplos.bioswork.modelos.Usuario;

@Repository
public interface IRepositorioUsuario extends JpaRepository<Usuario,String>{

    @Override
    @EntityGraph(type = EntityGraphType.LOAD, attributePaths = {"nombreUsuario"})
    List<Usuario> findAll();

    @Override
    @EntityGraph(type = EntityGraphType.LOAD, attributePaths = {"nombreUsuario"})
    Optional<Usuario> findById(String nombreUsuario);

    
}
