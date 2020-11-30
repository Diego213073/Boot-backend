package com.spring.app.bootbackend.exceptions;

public class ClientNoFoundException extends RuntimeException{

    public ClientNoFoundException(){
        super("Cliente no encontrado");
    }
}
