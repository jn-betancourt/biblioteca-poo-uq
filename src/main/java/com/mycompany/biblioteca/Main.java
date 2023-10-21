/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.biblioteca;

import com.mycompany.biblioteca.records.Libro;
import com.mycompany.biblioteca.records.LibroCD;
import com.mycompany.biblioteca.records.LibroDigital;
import com.mycompany.biblioteca.records.LibroImpreso;
import com.mycompany.biblioteca.records.Autor;
import com.mycompany.biblioteca.records.Editorial;
import com.mycompany.biblioteca.records.Formato;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Autor marcoAurelio = new Autor(1, "Marco Aurelio", "Romano");
        Editorial editroial = new Editorial(1, "Pensamiento", 123);
        Libro l1 = new LibroImpreso("Meditaciones", new Date(), marcoAurelio, editroial);
        Libro l2 = new LibroDigital("Cartas a Lucilio", new Date(), marcoAurelio, editroial, "https://db.books/libros/get/nombre=Meditaciones");
        Libro l3 = new LibroCD("La republica", new Date(), marcoAurelio, editroial, 5, Formato.MP3);
        
        Biblioteca biblioteca = new Biblioteca("UQ", 50);
        biblioteca.agregarLibroImpreso(l1);
        biblioteca.agregarLibroDigital(l2);
        biblioteca.agregarLibroCD(l3);
        
        System.out.println(biblioteca.getCantidadLibrosAutor(marcoAurelio));
    }
}
