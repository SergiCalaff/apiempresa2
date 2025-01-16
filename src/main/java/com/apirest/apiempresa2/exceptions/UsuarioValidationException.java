package com.apirest.apiempresa2.exceptions;

public class UsuarioValidationException extends RuntimeException {
    public UsuarioValidationException(String mensaje) {
        super(mensaje);
    };
}
