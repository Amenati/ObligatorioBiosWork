package uy.edu.bios.ejemplos.bioswork.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import uy.edu.bios.ejemplos.bioswork.dominio.Postulante;
import uy.edu.bios.ejemplos.bioswork.excepciones.ExcepcionBiosWork;
import uy.edu.bios.ejemplos.bioswork.excepciones.ExcepcionNoExiste;
import uy.edu.bios.ejemplos.bioswork.excepciones.ExcepcionYaExiste;
import uy.edu.bios.ejemplos.bioswork.repositorios.IRepositorioPostulantes;

@Service
public class ServicioPostulantes implements IServicioPostulantes {

    @Autowired
    private IRepositorioPostulantes repositorioPostulantes;

    @Override
    public Page<Postulante> listar(Pageable pageable) {
        return repositorioPostulantes.findAll(pageable);
    }

    @Override
    public Page<Postulante> buscar(String filtro, Pageable pageable) {
        if (filtro == null || filtro.isBlank()) {
            return listar(pageable);
        }

        return repositorioPostulantes.buscar(filtro, pageable);
    }

    @Override
    public Postulante obtener(String nombreUsuario) {
        return repositorioPostulantes.findById(nombreUsuario).orElse(null);
    }

    @Override
    public void ingresar(Postulante postulante) throws ExcepcionBiosWork {
        Postulante postulanteExistente = repositorioPostulantes.findById(postulante.getNombreUsuario()).orElse(null);
    
        if (postulanteExistente != null) {
            throw new ExcepcionYaExiste("El postulante ya existe");
        }

        repositorioPostulantes.save(postulante);
    }

    @Override
    public void modificar(Postulante postulante) throws ExcepcionBiosWork {
        Postulante postulanteExistente = repositorioPostulantes.findById(postulante.getNombreUsuario()).orElse(null);
    
        if (postulanteExistente == null) {
            throw new ExcepcionNoExiste("El postulante no existe");
        }

        repositorioPostulantes.save(postulante);
    }

    @Override
    public void eliminar(String nombreUsuario) throws ExcepcionBiosWork {
        Postulante postulanteExistente = repositorioPostulantes.findById(nombreUsuario).orElse(null);
    
        if (postulanteExistente == null) {
            throw new ExcepcionNoExiste("El postulante no existe");
        }

        repositorioPostulantes.deleteById(nombreUsuario);
    }
    
}
