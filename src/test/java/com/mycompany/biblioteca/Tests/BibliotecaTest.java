package com.mycompany.biblioteca.Tests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.mycompany.biblioteca.Biblioteca;
import com.mycompany.biblioteca.records.Libro;
import com.mycompany.biblioteca.records.LibroCD;
import com.mycompany.biblioteca.records.LibroDigital;
import com.mycompany.biblioteca.records.LibroImpreso;
import com.mycompany.biblioteca.records.Autor;
import com.mycompany.biblioteca.records.Editorial;
import com.mycompany.biblioteca.records.Formato;

import java.util.*;

/**
 * The class BibliotecaTest contains unit tests for the Biblioteca class.
 */
public class BibliotecaTest {
    
    private Autor autor = new Autor(1, "Autor", "COL");
    private Editorial editorial = new Editorial(1, "Editorial1", 300);

    @Test
    void testAgregarLibro() {
        var libro = new LibroImpreso("Jupiter", new Date(), autor, editorial);
        var biblioteca = new Biblioteca("UNIQUINDIO", 5);
        biblioteca.agregarLibroImpreso(libro);
        assertEquals(biblioteca.getCantidadLibros(), 1);
    }

    @Test
    void testGetCantidadLibros() {
        var libro = new LibroImpreso("Jupiter", new Date(), autor, editorial);
        var libro2 = new LibroImpreso("Jam", new Date(), autor, editorial);
        var biblioteca = new Biblioteca("CRAI", 5);
        biblioteca.agregarLibroImpreso(libro);
        biblioteca.agregarLibroImpreso(libro2);
        assertEquals(biblioteca.getCantidadLibros(), 2);
    }

    @Test
    void testGetLibros() {
        var libro1 = new LibroImpreso("Jupiter", new Date(), autor, editorial);
        var libro2 = new LibroImpreso("Jam", new Date(), autor, editorial);
        var libro3 = new LibroImpreso("Var", new Date(), autor, editorial);
        var biblioteca = new Biblioteca("UQ virtual", 4);
        biblioteca.agregarLibroImpreso(libro1);
        biblioteca.agregarLibroImpreso(libro2);
        biblioteca.agregarLibroImpreso(libro3);

        ArrayList<Libro> libros = new ArrayList<Libro>();
        libros.add(libro1);
        libros.add(libro2);
        libros.add(libro3);

        assertEquals(biblioteca.getLibros(), libros);;
    }
    @Test
    void agregarLibroErroneo() {
        var libro1 = new LibroImpreso("Jupiter", new Date(), autor, editorial);
        var biblioteca = new Biblioteca("UQ virtual", 2);
        assertThrows(AssertionError.class, ()->{
            biblioteca.agregarLibroDigital(libro1);
        });
    }

    @Test
    void cantidadLibrosAutor() {
        Libro l1 = new LibroImpreso("Meditaciones", new Date(), autor, editorial);
        Libro l2 = new LibroDigital("Cartas a Lucilio", new Date(), autor, editorial, "https://db.books/libros/get/nombre=Meditaciones");
        Libro l3 = new LibroCD("La republica", new Date(), autor, editorial, 5, Formato.MP3);
        
        Biblioteca biblioteca = new Biblioteca("UQ", 5);
        biblioteca.agregarLibroImpreso(l1);
        biblioteca.agregarLibroDigital(l2);
        biblioteca.agregarLibroCD(l3);

        String mensaje_esperado = "Libros Impresos: 1, Cantidad digitales: 1, CDs: 1";
        assertEquals(biblioteca.getCantidadLibrosAutor(autor), mensaje_esperado);
    }

    @Test
    void buscarLibroNombreFormato(){
        Libro l1 = new LibroCD("Libro", new Date(), autor, editorial, 2, Formato.MP4);
        Biblioteca biblioteca = new Biblioteca("UQ", 5);
        biblioteca.agregarLibroCD(l1);

        assertEquals(l1, biblioteca.getLibroPorNombreFormato("Libro", Formato.MP4).get());
    }

    @Test
    void buscarDigitalConVersionImpresa(){
        Collection<Libro> libros = new ArrayList<>();
        Libro l1 = new LibroDigital("Cartas a Lucilio", new Date(), autor, editorial, "https://db.books/libros/get/nombre=Meditaciones");
        Libro l2 = new LibroImpreso("Cartas a Lucilio", new Date(), autor, editorial);
        Biblioteca biblioteca = new Biblioteca("UQ", 5);
        biblioteca.agregarLibroDigital(l1);
        biblioteca.agregarLibroImpreso(l2);

        libros.add(l1);
        libros.add(l2);

        Collection<Libro> coleccion = new ArrayList<>();
        coleccion.add(l2);
        assertEquals(coleccion, biblioteca.buscarDigitalConVersionImpresa());
    }
}
