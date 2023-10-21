package com.mycompany.biblioteca.records;

import java.util.Date;

public class LibroCD extends Libro{
    private int tamañoMB;
    private Formato formato;

    public LibroCD(String nombre, Date fechaPublicacion, Autor autor, Editorial Editorial, int tamañoMB, Formato formato){
        super(nombre, fechaPublicacion, autor, Editorial);
        assert tamañoMB > 0;
        assert formato != null;
        this.tamañoMB = tamañoMB;
        this.formato = formato;
    }

    public int getTamañoMB() {
        return tamañoMB;
    }

    public Formato getFormato() {
        return formato;
    }

    @Override
    public String toString() {
        return "LibroCD ["+ super.toString() +"tamañoMB=" + tamañoMB + ", formato=" + formato + "]";
    }
}
