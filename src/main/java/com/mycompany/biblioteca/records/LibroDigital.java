package com.mycompany.biblioteca.records;

import java.util.Date;

public class LibroDigital extends Libro{
    private String url;
    
    public LibroDigital(String nombre, Date fechaPublicacion, Autor autor, Editorial editorial, String url){
        super(nombre, fechaPublicacion, autor, editorial);
        assert !url.isBlank();
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "LibroDigital ["+super.toString()+"url=" + url + "]";
    }
}