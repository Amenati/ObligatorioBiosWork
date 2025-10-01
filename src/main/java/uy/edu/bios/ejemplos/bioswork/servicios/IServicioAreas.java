package uy.edu.bios.ejemplos.bioswork.servicios;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import uy.edu.bios.ejemplos.bioswork.dominio.Area;
import uy.edu.bios.ejemplos.bioswork.excepciones.ExcepcionBiosWork;

public interface IServicioAreas {
    
    Page<Area> listar(Pageable pageable);
    Page<Area> buscar(String filtro, Pageable pageable);
    Area obtener(Long id);
    void ingresar(Area area) throws ExcepcionBiosWork;
    void modificar(Area area) throws ExcepcionBiosWork;
    void eliminar(Long id) throws ExcepcionBiosWork; 
}
