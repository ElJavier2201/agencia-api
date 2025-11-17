package com.agencia.api.modelo;

public class Servicio {
    private int idServicio;
    private String nombre;
    private String descripcion;
    private int idTipoServicio;
    private double precioBase;
    private int duracionEstimadaMin;

    // Campos extra para el JOIN
    private String nombreTipo;

    // Getters y Setters
    public int getIdServicio() { return idServicio; }
    public void setIdServicio(int idServicio) { this.idServicio = idServicio; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public int getIdTipoServicio() { return idTipoServicio; }
    public void setIdTipoServicio(int idTipoServicio) { this.idTipoServicio = idTipoServicio; }
    public double getPrecioBase() { return precioBase; }
    public void setPrecioBase(double precioBase) { this.precioBase = precioBase; }
    public int getDuracionEstimadaMin() { return duracionEstimadaMin; }
    public void setDuracionEstimadaMin(int duracionEstimadaMin) { this.duracionEstimadaMin = duracionEstimadaMin; }
    public String getNombreTipo() { return nombreTipo; }
    public void setNombreTipo(String nombreTipo) { this.nombreTipo = nombreTipo; }
}