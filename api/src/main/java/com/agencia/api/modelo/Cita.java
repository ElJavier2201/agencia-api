package com.agencia.api.modelo;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

public class Cita {

    private int idCita;
    private int idServicio;
    private Integer idCliente; // Usamos Integer (objeto) para que pueda ser null

    private String nombreCliente;
    private String emailCliente;
    private String telefonoCliente;

    private String vehiculoInfo; // Ej: "Ford Mustang"
    private int vehiculoAnio;

    private Date fechaCita;
    private Time horaCita;

    private String estado;
    private String comentarios;
    private Timestamp fechaCreacion;

    // --- Campo extra para el frontend ---
    private String nombreServicio;

    // --- Getters y Setters (Importante: deben ser públicos) ---
    public int getIdCita() { return idCita; }
    public void setIdCita(int idCita) { this.idCita = idCita; }

    public int getIdServicio() { return idServicio; }
    public void setIdServicio(int idServicio) { this.idServicio = idServicio; }

    public Integer getIdCliente() { return idCliente; }
    public void setIdCliente(Integer idCliente) { this.idCliente = idCliente; }

    public String getNombreCliente() { return nombreCliente; }
    public void setNombreCliente(String nombreCliente) { this.nombreCliente = nombreCliente; }

    public String getEmailCliente() { return emailCliente; }
    public void setEmailCliente(String emailCliente) { this.emailCliente = emailCliente; }

    public String getTelefonoCliente() { return telefonoCliente; }
    public void setTelefonoCliente(String telefonoCliente) { this.telefonoCliente = telefonoCliente; }

    public String getVehiculoInfo() { return vehiculoInfo; }
    public void setVehiculoInfo(String vehiculoInfo) { this.vehiculoInfo = vehiculoInfo; }

    public int getVehiculoAnio() { return vehiculoAnio; }
    public void setVehiculoAnio(int vehiculoAnio) { this.vehiculoAnio = vehiculoAnio; }

    public Date getFechaCita() { return fechaCita; }
    public void setFechaCita(Date fechaCita) { this.fechaCita = fechaCita; }

    public Time getHoraCita() { return horaCita; }
    public void setHoraCita(Time horaCita) { this.horaCita = horaCita; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public String getComentarios() { return comentarios; }
    public void setComentarios(String comentarios) { this.comentarios = comentarios; }

    public Timestamp getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(Timestamp fechaCreacion) { this.fechaCreacion = fechaCreacion; }

    public String getNombreServicio() { return nombreServicio; }
    public void setNombreServicio(String nombreServicio) { this.nombreServicio = nombreServicio; }
}