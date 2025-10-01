package uy.edu.bios.ejemplos.bioswork.servicios;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import uy.edu.bios.ejemplos.bioswork.dominio.Consultor;
import uy.edu.bios.ejemplos.bioswork.excepciones.ExcepcionBiosWork;

public interface IServicioConsultores {
    
    Page<Consultor> listar(Pageable pageable);
    Page<Consultor> buscar(String filtro, Pageable pageable);
    Consultor obtener(String nombreUsuario);
    void ingresar(Consultor consultor) throws ExcepcionBiosWork;
    void modificar(Consultor consultor) throws ExcepcionBiosWork;
    void eliminar(String nombreUsuario) throws ExcepcionBiosWork;
}
