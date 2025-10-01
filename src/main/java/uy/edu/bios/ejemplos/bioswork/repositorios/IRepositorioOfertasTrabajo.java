package uy.edu.bios.ejemplos.bioswork.repositorios;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import uy.edu.bios.ejemplos.bioswork.dominio.OfertaTrabajo;

public interface IRepositorioOfertasTrabajo extends JpaRepository<OfertaTrabajo, Long> {
    
    @Query("Select o From OfertaTrabajo o Where Cast(id As String) = ?1")
    Page<OfertaTrabajo> buscar(String filtro, Pageable pageable);
}
