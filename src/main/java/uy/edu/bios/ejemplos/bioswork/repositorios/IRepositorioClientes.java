package uy.edu.bios.ejemplos.bioswork.repositorios;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import uy.edu.bios.ejemplos.bioswork.dominio.Cliente;

public interface IRepositorioClientes extends JpaRepository<Cliente, String> {
    
    @Query("Select c From Cliente c Where nombreUsuario = ?1")
    Page<Cliente> buscar(String filtro, Pageable pageable);
}
