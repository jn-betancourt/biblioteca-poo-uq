/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package com.mycompany.biblioteca.records;
import java.util.*;

public record Libro(String nombre, Date fechaPublicacion, Autor autor) {
    public Libro{
        assert !nombre.isBlank();
        assert fechaPublicacion != null;
    }
}
