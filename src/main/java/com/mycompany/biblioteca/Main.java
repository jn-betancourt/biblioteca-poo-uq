/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.biblioteca;

import com.mycompany.biblioteca.records.Libro;
import com.mycompany.biblioteca.records.Autor;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Autor nuevoAutor = new Autor("Juan", "Betancourt");
        Autor marcoAurelio = new Autor("Marco", "Aurelio");
        Libro l1 = new Libro("El olvido que seremos", new Date(), nuevoAutor);
        Libro l2 = new Libro("Meditaciones", new Date(), marcoAurelio);
        
        Biblioteca biblioteca = new Biblioteca("");
        biblioteca.agregarLibro(l1);
        biblioteca.agregarLibro(l2);
        
        System.out.println(biblioteca.getLibroPorNombre("Meditaciones").isPresent());
        System.out.println(biblioteca.getLibroPorAutor("Marco").isPresent());
    }
}
