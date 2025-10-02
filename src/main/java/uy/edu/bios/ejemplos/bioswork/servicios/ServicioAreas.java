package uy.edu.bios.ejemplos.bioswork.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import uy.edu.bios.ejemplos.bioswork.dominio.Area;
import uy.edu.bios.ejemplos.bioswork.excepciones.ExcepcionBiosWork;
import uy.edu.bios.ejemplos.bioswork.excepciones.ExcepcionNoExiste;
import uy.edu.bios.ejemplos.bioswork.excepciones.ExcepcionYaExiste;
import uy.edu.bios.ejemplos.bioswork.repositorios.IRepositorioAreas;

@Service
public class ServicioAreas implements IServicioAreas {

    @Autowired
    private IRepositorioAreas repositorioAreas;

    @Override
    public Page<Area> listar(Pageable pageable) {
        return repositorioAreas.findAll(pageable);
    }

    @Override
    //@Transactional
    public Page<Area> buscar(String filtro, Pageable pageable) {
        if (filtro == null || filtro.isBlank()) {
            return listar(pageable);
        }

        return repositorioAreas.buscar(filtro, pageable);
    }

    @Override
    public Area obtener(Long id) {
        return repositorioAreas.findById(id).orElse(null);
    }

    @Override
    public void ingresar(Area area) throws ExcepcionBiosWork {
        Area areaExistente = repositorioAreas.findById(area.getId()).orElse(null);

        if (areaExistente != null) {
            throw new ExcepcionYaExiste("El área ya existe");
        }

        repositorioAreas.save(area);
    }

    @Override
    public void modificar(Area area) throws ExcepcionBiosWork {
        Area areaExistente = repositorioAreas.findById(area.getId()).orElse(null);

        if (areaExistente == null) {
            throw new ExcepcionNoExiste("El área no existe");
        }

        repositorioAreas.save(area);        
    }

    @Override
    public void eliminar(Long id) throws ExcepcionBiosWork {
        Area areaExistente = repositorioAreas.findById(id).orElse(null);

        if (areaExistente == null) {
            throw new ExcepcionNoExiste("El área no existe");
        }

        repositorioAreas.deleteById(id);        
    }
    
}
