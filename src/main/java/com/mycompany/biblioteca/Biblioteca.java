package com.mycompany.biblioteca;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import java.util.ArrayList;
import com.mycompany.biblioteca.records.Libro;
import com.mycompany.biblioteca.records.LibroCD;
import com.mycompany.biblioteca.records.LibroDigital;
import com.mycompany.biblioteca.records.LibroImpreso;
import com.mycompany.biblioteca.records.Autor;
import com.mycompany.biblioteca.records.Formato;

public class Biblioteca {
    
    private String nombreBiblioteca;
    private int cantidadLibros;
    private Collection<Libro> libros;
    private Collection<LibroDigital> librosDigitales;
    private Collection<LibroImpreso> librosImpresos;
    private Collection<LibroCD> librosCDs;
    
    public Biblioteca(String nombreBiblioteca, int cantidadLibros){
        assert !nombreBiblioteca.isBlank();
        assert cantidadLibros > 0;
        this.nombreBiblioteca = nombreBiblioteca;
        this.cantidadLibros = cantidadLibros;
        this.libros = new ArrayList<>();
        this.librosDigitales = new ArrayList<>();
        this.librosImpresos = new ArrayList<>();
        this.librosCDs = new ArrayList<>();
    }
    
    /**
     * The function "agregarLibroDigital" adds a digital book to a collection if it is not a duplicate
     * and the maximum number of books has not been exceeded.
     * 
     * Args:
     *   libroDigital (Libro): The parameter "libroDigital" is an object of type "Libro" which
     * represents a digital book.
     */
    public void agregarLibroDigital(Libro libroDigital){
        assert libroDigital instanceof LibroDigital;

        Predicate<LibroDigital> duplicado = e -> e.getNombre().equals(libroDigital.getNombre());
        Boolean comprobacion = librosDigitales.stream().anyMatch(duplicado);
        // Verfica no hay duplicados digitales y no excede cantidad libros
        if(!comprobacion && libros.size() <= cantidadLibros){
            this.librosDigitales.add((LibroDigital)libroDigital);
            this.libros.add(libroDigital);
        }
    }

    /**
     * The function "agregarLibroImpreso" adds a printed book to a collection if it is not a duplicate
     * and the total number of books does not exceed a specified limit.
     * 
     * Args:
     *   libroImpreso (Libro): The parameter "libroImpreso" is an object of type "Libro" that
     * represents a printed book.
     */
    public void agregarLibroImpreso(Libro libroImpreso){
        assert libroImpreso instanceof LibroImpreso;

        Predicate<LibroImpreso> duplicado = e -> e.getNombre().equals(libroImpreso.getNombre());
        Boolean comprobacion = librosImpresos.stream().anyMatch(duplicado);
        // Verfica no hay duplicados Impresos y no excede cantidad libros
        if(!comprobacion && libros.size() <= cantidadLibros){
            this.librosImpresos.add((LibroImpreso)libroImpreso);
            this.libros.add(libroImpreso);
        }
    }

    /**
     * The function `agregarLibroCD` adds a `LibroCD` object to a list of `LibroCD` objects, as well as
     * a list of `Libro` objects, if there are no duplicates and the number of books does not exceed a
     * certain limit.
     * 
     * Args:
     *   libroCd (Libro): The parameter "libroCd" is of type "Libro" and represents a book or CD object
     * that we want to add to a collection.
     */
    public void agregarLibroCD(Libro libroCd){
        assert libroCd instanceof LibroCD;
        Predicate<Libro> duplicado = e -> e.getNombre().equals(libroCd.getNombre());
        Boolean comprobacion = librosCDs.stream().anyMatch(duplicado);
        // Verfica no hay duplicados y no excede cantidad libros
        if(!comprobacion && libros.size() <= cantidadLibros){
            this.librosCDs.add((LibroCD)libroCd);
            this.libros.add(libroCd);
        }
    }

    /**
     * The function returns an Optional object containing a book with a matching name, if found, from a
     * list of books.
     * 
     * Args:
     *   nombreLibro (String): The parameter "nombreLibro" is a String that represents the name of a
     * book.
     * 
     * Returns:
     *   The method is returning an Optional object that contains a Libro object.
     */
    public Optional<Libro> getLibroPorNombre(String nombreLibro){
        // Compara nombres libros con el parametro
        Predicate<Libro> statement = libro -> libro.getNombre().equals(nombreLibro);
        return libros.stream().filter(statement).findAny();
    }
    
    /**
     * The function returns an Optional object containing a book that matches the given author name.
     * 
     * Args:
     *   nombreAutor (String): The parameter "nombreAutor" is a String that represents the name of an
     * author.
     * 
     * Returns:
     *   The method is returning an Optional object that contains a Libro object.
     */
    public Optional<Libro> getLibroPorAutor(String nombreAutor){
        // Compara autores en libros con el parametro
        Predicate<Libro> statement = libro -> libro.getAutor().nombre().equals(nombreAutor);
        return libros.stream().filter(statement).findAny();
    }

    /**
     * The function getCantidadLibrosAutor returns the number of books written by a given author in
     * each category (printed books, digital books, and CDs).
     * 
     * Args:
     *   nombreAutor (Autor): The parameter "nombreAutor" is of type "Autor", which represents the
     * author of a book.
     * 
     * Returns:
     *   The method is returning a string that includes the number of books written by the specified
     * author in each category (printed books, digital books, and CDs). The string includes the counts
     * for each category.
     */
    public String getCantidadLibrosAutor(Autor nombreAutor){
        // Tomamos cada libro saca autor y compara el nombre
        Predicate<Libro> autor = e -> e.getAutor().nombre().equals(nombreAutor.nombre());
        // Se aplica a cada lista de libros
        int cantidadImpresos = (int)librosImpresos.stream().filter(autor).count();
        int cantidadDigitales = (int)librosDigitales.stream().filter(autor).count();
        int cantidadCd = (int)librosCDs.stream().filter(autor).count();
        return "Libros Impresos: "+cantidadImpresos+", Cantidad digitales: "+cantidadDigitales+", CDs: "+cantidadCd;
    }

    /**
     * The function returns an Optional object containing a LibroCD object that matches the given name
     * and format.
     * 
     * Args:
     *   nombre (String): The name of the book or CD that you want to search for.
     *   FormatoLibro (Formato): The parameter "FormatoLibro" is of type "Formato", which is the format
     * of the book (e.g., paperback, hardcover, ebook).
     * 
     * Returns:
     *   The method is returning an Optional object that contains a LibroCD object.
     */
    public Optional<LibroCD> getLibroPorNombreFormato(String nombre, Formato FormatoLibro){
        // Buscamos nombre y formato que coincidad
        Predicate<LibroCD> coincideNombreFormato = e -> e.getFormato().equals(FormatoLibro) && e.getNombre().equals(nombre);
        Optional<LibroCD> libro = librosCDs.stream().filter(coincideNombreFormato).findAny(); // regresamos un opcional
        return libro;
    }

    /**
     * The function searches for books that have both a digital version and a printed version.
     * 
     * Returns:
     *   The method is returning a collection of books (type Libro) that have both a digital version
     * and a printed version.
     */
    public Collection<Libro> buscarDigitalConVersionImpresa(){
        Collection<Libro> libros = new ArrayList<>();
        for(Libro libro : librosDigitales){
            Predicate<Libro> digital = e -> e.getNombre().equals(libro.getNombre());
            libros = librosImpresos.stream().filter(digital).collect(Collectors.toList());
        }
        return libros;
    }

    public Collection<Libro> getLibros(){
        return this.libros;
    }
    
    public int getCantidadLibros(){
        return this.libros.size();
    }
    public String getNombreBiblioteca() {
        return nombreBiblioteca;
    }

    public void setNombreBiblioteca(String nombreBiblioteca) {
        this.nombreBiblioteca = nombreBiblioteca;
    }
    
    public Collection<LibroDigital> getLibrosDigitales() {
        return librosDigitales;
    }

    public Collection<LibroImpreso> getLibrosImpresos() {
        return librosImpresos;
    }

    public Collection<LibroCD> getLibrosCDs() {
        return librosCDs;
    }
}