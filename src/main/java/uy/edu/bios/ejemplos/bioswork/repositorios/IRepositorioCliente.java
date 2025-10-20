package uy.edu.bios.ejemplos.bioswork.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;

import uy.edu.bios.ejemplos.bioswork.modelos.Cliente;

public interface IRepositorioCliente extends JpaRepository<Cliente,String>{
    
    @Override
    @EntityGraph(type = EntityGraphType.LOAD, attributePaths = {"roles"})
    List<Cliente> findAll();

    @Override
    @EntityGraph(type = EntityGraphType.LOAD, attributePaths = {"roles"})
    Optional<Cliente> findById(String id);
}
