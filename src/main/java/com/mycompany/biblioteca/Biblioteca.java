package com.mycompany.biblioteca;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.ArrayList;
import com.mycompany.biblioteca.records.Libro;

public class Biblioteca {
    
    private String nombreBiblioteca;
    private Collection<Libro> libros;
    
    public Biblioteca(String nombreBiblioteca){
        assert !nombreBiblioteca.isBlank();

        this.nombreBiblioteca = nombreBiblioteca;
        this.libros = new ArrayList<>();
    }
    
    public void agregarLibro(Libro libro){
        this.libros.add(libro);
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

    public Optional<Libro> getLibroPorNombre(String nombreLibro){
        Predicate<Libro> statement = libro -> libro.nombre().equals(nombreLibro);
        return libros.stream().filter(statement).findAny();
    }

    public Optional<Libro> getLibroPorAutor(String nombreAutor){
        Predicate<Libro> statement = libro -> libro.autor().nombre().equals(nombreAutor);
        return libros.stream().filter(statement).findAny();
    }
  
}
