package uy.edu.bios.ejemplos.bioswork.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import uy.edu.bios.ejemplos.bioswork.dominio.Cliente;
import uy.edu.bios.ejemplos.bioswork.excepciones.ExcepcionBiosWork;
import uy.edu.bios.ejemplos.bioswork.excepciones.ExcepcionNoExiste;
import uy.edu.bios.ejemplos.bioswork.excepciones.ExcepcionYaExiste;
import uy.edu.bios.ejemplos.bioswork.repositorios.IRepositorioClientes;

@Service    
public class ServicioClientes implements IservicioClientes {

    @Autowired
    private IRepositorioClientes repositorioClientes;

    @Override
    public Page<Cliente> listar(Pageable pageable) {
        return repositorioClientes.findAll(pageable);
    }

    @Override
    public Page<Cliente> buscar(String filtro, Pageable pageable) {
        if (filtro == null || filtro.isBlank()) {
            return listar(pageable);
        }

        return repositorioClientes.buscar(filtro, pageable);
    }

    @Override
    public Cliente obtener(String nombreUsuario) {
        return repositorioClientes.findById(nombreUsuario).orElse(null);
    }

    @Override
    public void ingresar(Cliente cliente) throws ExcepcionBiosWork {
        Cliente clienteExistente = repositorioClientes.findById(cliente.getNombreUsuario()).orElse(null);
    
        if (clienteExistente != null) {
            throw new ExcepcionYaExiste("El cliente ya existe");
        }

        repositorioClientes.save(cliente);
    }

    @Override
    public void modificar(Cliente cliente) throws ExcepcionBiosWork {
        Cliente clienteExistente = repositorioClientes.findById(cliente.getNombreUsuario()).orElse(null);
    
        if (clienteExistente == null) {
            throw new ExcepcionNoExiste("El cliente no existe");
        }

        repositorioClientes.save(cliente);
    }

    @Override
    public void eliminar(String nombreUsuario) throws ExcepcionBiosWork {
        Cliente clienteExistente = repositorioClientes.findById(nombreUsuario).orElse(null);
    
        if (clienteExistente == null) {
            throw new ExcepcionNoExiste("El cliente no existe");
        }

        repositorioClientes.deleteById(nombreUsuario);
    }
    
}
