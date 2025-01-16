package com.apirest.apiempresa2.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data   //implementa getter, setter, to string
@Table(name = "usuario")
@AllArgsConstructor  //crea constructor 
@NoArgsConstructor  //crea constructor vacio
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //identificamos la PK con id_usuario
    @Column(name = "id_usuario")
    private Long idUsuario;

    @Column(name = "nombre", nullable = false)
    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "id_rol", nullable = false)
    @Valid      // Valida el rol antes de persistir y evita exponer la entidad directamente 
    private Rol rol;

    @ManyToOne
    @JoinColumn(name = "id_ubicacion", nullable = false)
    @Valid
    private Ubicacion ubicacion;

    @Column(name = "email", nullable = false, unique = true)
    @NotBlank(message = "El email es obligatorio")
    @Email(message = "Debe ser un email válido")
    private String email;
}
