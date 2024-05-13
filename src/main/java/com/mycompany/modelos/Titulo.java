/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.modelos;

import Excepciones.ErrorEnConversionException;
import com.google.gson.annotations.SerializedName;

/**
 *
 * @author Faby
 */
public class Titulo implements Comparable<Titulo>{
     //@SerializedName("Title") // esto significa que cuando encuentre Title en el json, lo va a meter en nombre.
    private String nombre;
    
    //@SerializedName("Year")
    private int fechaDeLanzamiento;
    
    private int duracionEnMinutos;
    private boolean incluidoEnElPlan;
    private double sumaDeEvaluaciones; // una clase externa no consigue ver estos atributos ni asignarles un valor porq son private
    private int totalDeLasEvaluaciones;

    
    public Titulo(String nombre, int fechaDeLanzamiento) {
        this.nombre = nombre;
        this.fechaDeLanzamiento = fechaDeLanzamiento;
       
    }

//    public Titulo() {
//    this.nombre = ""; 
//    this.fechaDeLanzamiento = 0; 
//}

    public Titulo(PeliculaOMDB tituloomdb) {
        this.nombre=tituloomdb.title();
        this.fechaDeLanzamiento= Integer.valueOf(tituloomdb.year());
        if(tituloomdb.runtime().contains("N/A")){
            throw new ErrorEnConversionException("No se a podido convertir la duracion porque contiene un N/a");
        }
        this.duracionEnMinutos=Integer.valueOf(tituloomdb.runtime().substring(0,3).replace(" ", ""));
    
    }

    private int getTotalDeLasEvaluaciones() {
        return totalDeLasEvaluaciones;
    }

    
    public int getTotalDeEvaluaciones(){
        return getTotalDeLasEvaluaciones();
    }
    
    public void muestraFichaTecnica(){
         System.out.println("El nombre de la pelicula es: " + getNombre() + ", fue lanzada en " + getFechaDeLanzamiento()+ "y su duracion es: " + getDuracionEnMinutos());
    }
    
    public void evalua(double nota){
        setSumaDeEvaluaciones(getSumaDeEvaluaciones() + nota);
        setTotalDeLasEvaluaciones(getTotalDeLasEvaluaciones() + 1);
    }
    
    public double calculaMedia(){
        return getSumaDeEvaluaciones()/ getTotalDeLasEvaluaciones();
    }

    
    public String getNombre() {
        return nombre;
    }

    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    public int getFechaDeLanzamiento() {
        return fechaDeLanzamiento;
    }

    
    public void setFechaDeLanzamiento(int fechaDeLanzamiento) {
        this.fechaDeLanzamiento = fechaDeLanzamiento;
    }

    
    public int getDuracionEnMinutos() {
        return duracionEnMinutos;
    }

   
    public void setDuracionEnMinutos(int duracionEnMinutos) {
        this.duracionEnMinutos = duracionEnMinutos;
    }

    
    public boolean isIncluidoEnElPlan() {
        return incluidoEnElPlan;
    }

    
    public void setIncluidoEnElPlan(boolean incluidoEnElPlan) {
        this.incluidoEnElPlan = incluidoEnElPlan;
    }

    
    public double getSumaDeEvaluaciones() {
        return sumaDeEvaluaciones;
    }

    /**
     * @param sumaDeEvaluaciones the sumaDeEvaluaciones to set
     */
    public void setSumaDeEvaluaciones(double sumaDeEvaluaciones) {
        this.sumaDeEvaluaciones = sumaDeEvaluaciones;
    }

    
   
    
    public void setTotalDeLasEvaluaciones(int totalDeLasEvaluaciones) {
        this.totalDeLasEvaluaciones = totalDeLasEvaluaciones;
    }

    @Override
    public String toString() {
        return "( nombre: " + nombre + ", fechaDeLanzamiento: " + fechaDeLanzamiento +", Duracion: " + duracionEnMinutos +" )";
    }

    @Override
    public int compareTo(Titulo otroTitulo) {
        return this.getNombre().compareToIgnoreCase(otroTitulo.getNombre());
    }

    
    
    
    
    
}
