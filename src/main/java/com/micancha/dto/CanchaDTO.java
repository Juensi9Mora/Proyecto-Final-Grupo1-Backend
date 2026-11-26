package com.micancha.dto;

import com.micancha.entity.CanchaEntity;
import java.math.BigDecimal;

public class CanchaDTO {

    private Long id;
    private String nombre;
    private String imagenUrl;
    private String descripcion;
    private String direccion;
    private String direccionUrl;
    private String pais;
    private String ciudad;
    private String categoria;
    private BigDecimal precioHora;
    private String estado;

    public CanchaDTO() {
    }

    public CanchaDTO(Long id, String nombre, String imagenUrl,
                     String descripcion, String direccion,
                     String direccionUrl, String pais,
                     String ciudad, String categoria,
                     BigDecimal precioHora, String estado) {

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

    public static CanchaDTO fromEntity(CanchaEntity cancha) {

        return new CanchaDTO(
                cancha.getId(),
                cancha.getNombre(),
                cancha.getImagenUrl(),
                cancha.getDescripcion(),
                cancha.getDireccion(),
                cancha.getDireccionUrl(),
                cancha.getPais(),
                cancha.getCiudad(),
                cancha.getCategoria(),
                cancha.getPrecioHora(),
                cancha.getEstado()
        );
    }

    // Convertir DTO a entidad
    public CanchaEntity toEntity() {

        return new CanchaEntity(
                this.nombre,
                this.imagenUrl,
                this.descripcion,
                this.direccion,
                this.direccionUrl,
                this.pais,
                this.ciudad,
                this.categoria,
                this.precioHora,
                this.estado
        );
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
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

}