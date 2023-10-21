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

    public Optional<Libro> getLibroPorNombre(String nombreLibro){
        // Compara nombres libros con el parametro
        Predicate<Libro> statement = libro -> libro.getNombre().equals(nombreLibro);
        return libros.stream().filter(statement).findAny();
    }
    
    public Optional<Libro> getLibroPorAutor(String nombreAutor){
        // Compara autores en libros con el parametro
        Predicate<Libro> statement = libro -> libro.getAutor().nombre().equals(nombreAutor);
        return libros.stream().filter(statement).findAny();
    }

    public String getCantidadLibrosAutor(Autor nombreAutor){
        // Tomamos cada libro saca autor y compara el nombre
        Predicate<Libro> autor = e -> e.getAutor().nombre().equals(nombreAutor.nombre());
        // Se aplica a cada lista de libros
        int cantidadImpresos = (int)librosImpresos.stream().filter(autor).count();
        int cantidadDigitales = (int)librosDigitales.stream().filter(autor).count();
        int cantidadCd = (int)librosCDs.stream().filter(autor).count();
        return "Libros Impresos: "+cantidadImpresos+", Cantidad digitales: "+cantidadDigitales+", CDs: "+cantidadCd;
    }

    public Optional<LibroCD> getLibroPorNombreFormato(String nombre, Formato FormatoLibro){
        // Buscamos nombre y formato que coincidad
        Predicate<LibroCD> coincideNombreFormato = e -> e.getFormato().equals(FormatoLibro) && e.getNombre().equals(nombre);
        Optional<LibroCD> libro = librosCDs.stream().filter(coincideNombreFormato).findAny(); // regresamos un opcional
        return libro;
    }

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