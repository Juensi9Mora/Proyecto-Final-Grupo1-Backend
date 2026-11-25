package com.micancha.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "canchas")
public class CanchaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120)
    private String nombre;

    @Column(name = "imagen_url", nullable = false, length = 500)
    private String imagenUrl;

    @Column(nullable = false, length = 1000)
    private String descripcion;

    @Column(nullable = false, length = 500)
    private String direccion;

    @Column(name = "direccion_url", nullable = false, length = 500)
    private String direccionUrl;

    @Column(nullable = false, length = 80)
    private String pais;

    @Column(nullable = false, length = 100)
    private String ciudad;

    @Column(nullable = false, length = 80)
    private String categoria;

    @Column(name = "precio_hora", precision = 10, scale = 2, nullable = false)
    private BigDecimal precioHora;

    @Column(nullable = false, length = 20)
    private String estado = "ACTIVA";

    public CanchaEntity() {
    }

    public CanchaEntity(String nombre, String imagenUrl, String descripcion, String direccion, String direccionUrl, String pais, String ciudad, String categoria, BigDecimal precioHora, String estado) {

        this.nombre = nombre;
        this.imagenUrl = imagenUrl;
        this.descripcion = descripcion;
        this.direccion = direccion;
        this.direccionUrl = direccionUrl;
        this.pais = pais;
        this.ciudad = ciudad;
        this.categoria = categoria;
        this.precioHora = precioHora;
        this.estado = estado;
    }

    public CanchaEntity(Long id, String nombre, String imagenUrl, String descripcion, String direccion, String direccionUrl, String pais, String ciudad, String categoria, BigDecimal precioHora, String estado) {

        this.id = id;
        this.nombre = nombre;
        this.imagenUrl = imagenUrl;
        this.descripcion = descripcion;
        this.direccion = direccion;
        this.direccionUrl = direccionUrl;
        this.pais = pais;
        this.ciudad = ciudad;
        this.categoria = categoria;
        this.precioHora = precioHora;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagenUrl() {
        return imagenUrl;
    }

    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDireccionUrl() {
        return direccionUrl;
    }

    public void setDireccionUrl(String direccionUrl) {
        this.direccionUrl = direccionUrl;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public BigDecimal getPrecioHora() {
        return precioHora;
    }

    public void setPrecioHora(BigDecimal precioHora) {
        this.precioHora = precioHora;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
