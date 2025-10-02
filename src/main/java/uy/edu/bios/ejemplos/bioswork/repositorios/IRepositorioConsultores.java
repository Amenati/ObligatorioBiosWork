package uy.edu.bios.ejemplos.bioswork.repositorios;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import uy.edu.bios.ejemplos.bioswork.dominio.Consultor;

public interface IRepositorioConsultores extends JpaRepository<Consultor, String> {

   @Query("Select c From Consultor c Where nombreUsuario Like CONCAT('%', ?1, '%')")
   Page<Consultor> buscar(String filtro, Pageable pageable);
}
