package com.mycompany.biblioteca.records;

public record Editorial(int id, String nombre, int telefono) {
    public Editorial{
        assert id > 0;
        assert !nombre.isBlank(); 
    }
}
