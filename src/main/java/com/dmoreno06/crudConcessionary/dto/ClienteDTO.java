package com.dmoreno06.crudConcessionary.dto;

import com.sun.istack.NotNull;

public class ClienteDTO {

    private String docIdentidad;
    private String nombre;
    private String apellidos;
    private String ciudad;
    private String numTelefono;

    public ClienteDTO(String docIdentidad, String nombre, String apellidos, String ciudad, String numTelefono) {
        this.docIdentidad = docIdentidad;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.ciudad = ciudad;
        this.numTelefono = numTelefono;
    }

    public String getDocIdentidad() {
        return docIdentidad;
    }

    public void setDocIdentidad(String docIdentidad) {
        this.docIdentidad = docIdentidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getNumTelefono() {
        return numTelefono;
    }

    public void setNumTelefono(String numTelefono) {
        this.numTelefono = numTelefono;
    }

    @Override
    public String toString() {
        return "ClienteDTO{" +
                "docIdentidad='" + docIdentidad + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", numTelefono='" + numTelefono + '\'' +
                '}';
    }
}
