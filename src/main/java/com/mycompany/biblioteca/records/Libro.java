/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package com.mycompany.biblioteca.records;
import java.util.*;

public abstract class Libro {
    private String nombre;
    private Date fechaPublicacion;
    private Autor autor;
    private Editorial editorial;
    public Libro(String nombre, Date fechaPublicacion, Autor autor, Editorial editorial) {
        this.nombre = nombre;
        this.fechaPublicacion = fechaPublicacion;
        this.autor = autor;
        this.editorial = editorial;
    }
    public String getNombre() {
        return nombre;
    }
    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }
    public Autor getAutor() {
        return autor;
    }
    public Editorial getEditorial() {
        return editorial;
    }
    @Override
    public String toString() {
        return "Libro [nombre=" + nombre + ", fechaPublicacion=" + fechaPublicacion + ", autor=" + autor
                + ", editorial=" + editorial + "]";
    }
}
