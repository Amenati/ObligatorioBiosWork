package uy.edu.bios.ejemplos.bioswork.repositorios;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import uy.edu.bios.ejemplos.bioswork.dominio.Area;


public interface IRepositorioAreas extends JpaRepository<Area, Long> {

    @Query("Select a From Area a Where Cast(id As String) = ?1")
    Page<Area> buscar(String id, Pageable pageable);
    
}
