package uy.edu.bios.ejemplos.bioswork.servicios;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import uy.edu.bios.ejemplos.bioswork.dominio.Cliente;
import uy.edu.bios.ejemplos.bioswork.excepciones.ExcepcionBiosWork;

public interface IservicioClientes {
    Page<Cliente> listar(Pageable pageable);
    Page<Cliente> buscar(String filtro, Pageable pageable);
    Cliente obtener(String nombreUsuario);
    void ingresar(Cliente cliente) throws ExcepcionBiosWork;
    void modificar(Cliente cliente) throws ExcepcionBiosWork;
    void eliminar(String nombreUsuario) throws ExcepcionBiosWork;
}
