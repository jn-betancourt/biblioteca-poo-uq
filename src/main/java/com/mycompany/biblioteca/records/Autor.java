package com.mycompany.biblioteca.records;

public record Autor(int id, String nombre, String nacionalidad) {
    public Autor{
        assert id > 0;
        assert !nombre.isBlank();
        assert !nacionalidad.isBlank();
    }
}
