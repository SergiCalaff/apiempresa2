package com.apirest.apiempresa2.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apirest.apiempresa2.models.Usuario;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByIdUsuario(Long idUsuario);

    List<Usuario> findByNombre(String nombre);

    List<Usuario> findByRolIdRol(Long idRol);

    List<Usuario> findByUbicacionIdUbicacion(Long idUbicacion);

    boolean existsByEmail(String email);
}
