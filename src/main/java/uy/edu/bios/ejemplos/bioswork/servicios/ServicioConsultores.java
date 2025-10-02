package uy.edu.bios.ejemplos.bioswork.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import uy.edu.bios.ejemplos.bioswork.dominio.Consultor;
import uy.edu.bios.ejemplos.bioswork.excepciones.ExcepcionBiosWork;
import uy.edu.bios.ejemplos.bioswork.excepciones.ExcepcionNoExiste;
import uy.edu.bios.ejemplos.bioswork.excepciones.ExcepcionYaExiste;
import uy.edu.bios.ejemplos.bioswork.repositorios.IRepositorioConsultores;

@Service
public class ServicioConsultores implements IServicioConsultores {

    @Autowired
    private IRepositorioConsultores repositorioConsultores;

    @Override
    public Page<Consultor> listar(Pageable pageable) {
        return repositorioConsultores.findAll(pageable);
    }

    @Override
    //@Transactional
    public Page<Consultor> buscar(String filtro, Pageable pageable) {
       if (filtro == null || filtro.isBlank()) {
            return listar(pageable);
       } 

       return repositorioConsultores.buscar(filtro, pageable);
    }

    @Override
    public Consultor obtener(String nombreUsuario) {
        return repositorioConsultores.findById(nombreUsuario).orElse(null);
        
    }

    @Override
    public void ingresar(Consultor consultor) throws ExcepcionBiosWork {
        Consultor consultorExistente = repositorioConsultores.findById(consultor.getNombreUsuario()).orElse(null);
        
        if (consultorExistente != null) {
            throw new ExcepcionYaExiste("El consultor ya existe");
        }

        repositorioConsultores.save(consultor);
    }

    @Override
    public void modificar(Consultor consultor) throws ExcepcionBiosWork {
         Consultor consultorExistente = repositorioConsultores.findById(consultor.getNombreUsuario()).orElse(null);
        
        if (consultorExistente == null) {
            throw new ExcepcionNoExiste("El consultor no existe");
        }

        repositorioConsultores.save(consultor);       
        
    }

    @Override
    public void eliminar(String nombreUsuario) throws ExcepcionBiosWork {
        Consultor consultorExistente = repositorioConsultores.findById(nombreUsuario).orElse(null);
        
        if (consultorExistente == null) {
            throw new ExcepcionNoExiste("El consultor no existe");
        }

        repositorioConsultores.deleteById(nombreUsuario);
        
    }
    
}
