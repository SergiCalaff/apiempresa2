package com.apirest.apiempresa2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.apiempresa2.models.Ubicacion;
import com.apirest.apiempresa2.repositories.IUbicacionRepository;

@Service
public class UbicacionService {

    @Autowired
    private IUbicacionRepository ubicacionRepo;

    public Ubicacion crearUbicacion(Ubicacion ubicacion){
        return ubicacionRepo.save(ubicacion);
    }

    public List<Ubicacion> listarUbicacion(){
        return ubicacionRepo.findAll();
    }
    
    public List<Ubicacion> listarUbicacionPorId(Long idUbicacion){
        return ubicacionRepo.findByIdUbicacion(idUbicacion);
    }
    
    public List<Ubicacion> listarUbicacionPorNombre(String nombre){
        return ubicacionRepo.findByNombre(nombre);
    }
    
    public List<Ubicacion> listarUbicacionPorTipo(String tipo){
        return ubicacionRepo.findByNombre(tipo);
    }

    public Ubicacion actualizarUbicacion(Ubicacion ubicacion, Long id){
        
        
        
        return ubicacion;
    }
    
    

}
