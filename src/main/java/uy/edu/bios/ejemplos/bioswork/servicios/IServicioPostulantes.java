package uy.edu.bios.ejemplos.bioswork.servicios;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import uy.edu.bios.ejemplos.bioswork.dominio.Postulante;
import uy.edu.bios.ejemplos.bioswork.excepciones.ExcepcionBiosWork;

public interface IServicioPostulantes {
    Page<Postulante> listar(Pageable pageable);
    Page<Postulante> buscar(String filtro, Pageable pageable);
    Postulante obtener(String nombreUsuario);
    void ingresar(Postulante postulante) throws ExcepcionBiosWork;
    void modificar(Postulante postulante) throws ExcepcionBiosWork;
    void eliminar(String nombreUsuario) throws ExcepcionBiosWork;
}
