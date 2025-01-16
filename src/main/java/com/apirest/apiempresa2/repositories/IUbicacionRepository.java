package com.apirest.apiempresa2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apirest.apiempresa2.models.Ubicacion;

@Repository
public interface IUbicacionRepository extends JpaRepository<Ubicacion, Long> {
    List<Ubicacion> findByIdUbicacion(Long idUbicacion);
    List<Ubicacion> findByNombre (String nombre);
    List<Ubicacion> findByTipo(String tipo);
}
