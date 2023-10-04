package com.mycompany.biblioteca.records;

public record Autor(String nombre, String apellido) {
    public Autor{
        assert !nombre.isBlank();
        assert !apellido.isBlank();
    }
}
