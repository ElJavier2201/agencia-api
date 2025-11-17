package com.agencia.api.controlador.dto;

// Un simple "POJO" para mapear el JSON que enviará el frontend
public class LoginRequest {
    private String usuario;
    private String password;

    // Getters y Setters
    public String getUsuario() { return usuario; }
    public void setUsuario(String usuario) { this.usuario = usuario; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
