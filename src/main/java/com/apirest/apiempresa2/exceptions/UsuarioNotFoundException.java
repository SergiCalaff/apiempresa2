package com.apirest.apiempresa2.exceptions;

public class UsuarioNotFoundException extends RuntimeException{
    public UsuarioNotFoundException(String mensaje){
        super(mensaje);
    }
}
