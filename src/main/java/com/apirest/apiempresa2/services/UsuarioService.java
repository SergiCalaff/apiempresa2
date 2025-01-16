package com.apirest.apiempresa2.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.apirest.apiempresa2.models.Usuario;
import com.apirest.apiempresa2.repositories.IUsuarioRepository;

import jakarta.transaction.Transactional;

import com.apirest.apiempresa2.exceptions.UsuarioValidationException;
import com.apirest.apiempresa2.exceptions.UsuarioNotFoundException;

import lombok.RequiredArgsConstructor;

@Service
@Transactional   // @Transactional Añadirlo siempre en metodos que modifican datos para garantizar la integridad de la transacción
@RequiredArgsConstructor  //utilizando esta anotación, lombok genera automaticamente el constructor
                        //para todas las variables de instancia siempre que sean FINAL 
                        //y no hemos de poner @Autowired en el constructor
public class UsuarioService {

    private final IUsuarioRepository usuarioRepo; // instanciamos a la interfaz de repositorio

    // @Autowired // inyección de dependéncias, se recomienda en el constructor para facilitar las
    //            // pruebas unitarias
    // public UsuarioService(IUsuarioRepository usuarioRepo) {
    //     this.usuarioRepo = usuarioRepo;
    // }

    public Usuario crearUsuario(Usuario usuario) {

        if (usuarioRepo.existsByEmail(usuario.getEmail())) {
            throw new IllegalArgumentException("El email ya esta registado en la base");
        }
        return usuarioRepo.save(usuario);
    }

    public Usuario actualizarUsuario(Long id, Usuario usuario) {

        Usuario usuarioExiste = usuarioRepo.findByIdUsuario(id)
                .orElseThrow(() -> new UsuarioNotFoundException("No se ha encontrado al usuario con id: " + id));

        usuarioExiste.setNombre(usuario.getNombre());
        usuarioExiste.setRol(usuario.getRol());
        usuarioExiste.setUbicacion(usuario.getUbicacion());
        usuarioExiste.setEmail(usuario.getEmail());

        return usuarioRepo.save(usuarioExiste);
    }
    public void eliminarUsuario(Long id) {

        if (!usuarioRepo.existsById(id)) {
            throw new UsuarioNotFoundException("No se ha encontrado al usuario con id: " + id);
        }
        usuarioRepo.deleteById(id);
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepo.findAll();
    }

    public Usuario buscarUsuarioPorId(Long id) {// Usamos optional para poder gestionar excepción si no existe
        return usuarioRepo.findByIdUsuario(id)
                .orElseThrow(
                        () -> new UsuarioNotFoundException("No se ha encontrado ningún usuario con id: " + id));
    }

    public List<Usuario> buscarPorNombre(String nombre) {
        return usuarioRepo.findByNombre(nombre);
    }

    public List<Usuario> buscarPorRol(Long idRol) {
        return usuarioRepo.findByRolIdRol(idRol);
    }

    public List<Usuario> buscarPorUbicacion(Long idUbicacion) {
        return usuarioRepo.findByUbicacionIdUbicacion(idUbicacion);
    }

}
