package com.apirest.apiempresa2.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.apirest.apiempresa2.models.Usuario;
import com.apirest.apiempresa2.services.UsuarioService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController // devuelve datos tipo texto json, xml, si fuera solo controller devuelve
                // páginas web
@RequestMapping("/usuarios")
@RequiredArgsConstructor  // Nos crea directamente el constructor y evitamos @Autowired
public class UsuarioRestController {

    private UsuarioService usuarioService; // instancia al servicio para usar sus métodos

    // @Autowired
    // public UsuarioRestController(UsuarioService usuarioService) {
    //     this.usuarioService = usuarioService;
    // }

    @PostMapping("/crear")
    public ResponseEntity<?> crearUsuario(@Valid @RequestBody Usuario usuarios) {
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.crearUsuario(usuarios));
    }

    @PutMapping("/actualizar/{id_usuario}")
    public ResponseEntity<?> actualizarUsuario(@PathVariable Long idUsuario, @Valid @RequestBody Usuario usuario) {
        return ResponseEntity.ok(usuarioService.actualizarUsuario(idUsuario, usuario));
    }

    @DeleteMapping("/eliminar/{id_usuario}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminarUsuario(@PathVariable Long idUsuario) {
        usuarioService.eliminarUsuario(idUsuario);
    }

    @GetMapping
    public List<Usuario> listarUsuarios() {
        return usuarioService.listarUsuarios();
    }

    @GetMapping("/{id_usuario}")
    public Usuario buscarUsuarioPorId(@PathVariable Long idUsuario) { // @PathVariable detectará lo que está entre
        return usuarioService.buscarUsuarioPorId(idUsuario);
    }

    @GetMapping("/nombre/{nombre}")
    public List<Usuario> buscarPorNombre(@PathVariable String nombre) {
        return usuarioService.buscarPorNombre(nombre);
    }

    @GetMapping("/rol/{id_rol}")
    public List<Usuario> buscarPorRol(@PathVariable Long idRol) {
        return usuarioService.buscarPorRol(idRol);
    }

    @GetMapping("/ubicacion/{id_ubicacion}")
    public List<Usuario> buscarPorEmpresa(@PathVariable Long idUbicacion) {
        return usuarioService.buscarPorUbicacion(idUbicacion);
    }

}
