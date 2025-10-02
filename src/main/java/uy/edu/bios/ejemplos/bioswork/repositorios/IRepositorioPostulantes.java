package uy.edu.bios.ejemplos.bioswork.repositorios;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import uy.edu.bios.ejemplos.bioswork.dominio.Postulante;

public interface IRepositorioPostulantes extends JpaRepository<Postulante, String> {
    
    @Query("Select p From Postulante p Where nombreUsuario Like CONCAT('%', ?1, '%')")
    Page<Postulante> buscar(String filtro, Pageable pageable);
}
