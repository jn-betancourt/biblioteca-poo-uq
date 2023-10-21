/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package com.mycompany.biblioteca.records;
import java.util.Date;

public class LibroImpreso extends Libro{
    public LibroImpreso(String nombre, Date fechaPublicacion, Autor autor, Editorial editorial){
        super(nombre, fechaPublicacion, autor, editorial);
    }

    @Override
    public String toString() {
        return "LibroImpreso ["+ super.toString() +"]";
    }
}
