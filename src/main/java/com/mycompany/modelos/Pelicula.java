/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.modelos;

import calculos.Clasificacion;



/**
 *
 * @author Faby
 */
public class Pelicula extends Titulo implements Clasificacion {

    
   private String director;

   public Pelicula(String nombre,int fechaDeLanzamiento) {
        super(nombre,fechaDeLanzamiento);
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    
    
    
    @Override
    public int getClasificacion() { // se divide por dos porque la calificacion es de 1 a 10, y las estrellas solo son hasta 5
        return (int) (calculaMedia()/2);
    }

    @Override
    public String toString() {
        return ("Pelicula: " + this.getNombre() + "( " + this.getFechaDeLanzamiento()+ " )");
    }

    
   
    
}
