/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.modelos;

/**
 *
 * @author Faby
 */
public class Serie extends Titulo{
    
   private int temporadas;
   private int episodiosPorTemporada;
   private int minutosPorEpisodio;

    public Serie(String nombre,int fechaDeLanzamiento) {
        super(nombre,fechaDeLanzamiento);
    }
   
    
    public int getTemporadas() {
        return temporadas;
    }

    public int getEpisodiosPorTemporada() {
        return episodiosPorTemporada;
    }

    public int getMinutosPorEpisodio() {
        return minutosPorEpisodio;
    }

    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }

    public void setEpisodiosPorTemporada(int episodiosPorTemporada) {
        this.episodiosPorTemporada = episodiosPorTemporada;
    }
      
 
    public void setMinutosPorEpisodio(int minutosPorEpisodio) {
    this.minutosPorEpisodio = minutosPorEpisodio;
}

    
  @Override
public int getDuracionEnMinutos() {
    int duracionTotal = this.getTemporadas() * this.getEpisodiosPorTemporada() * this.getMinutosPorEpisodio();
    return duracionTotal;
}

@Override
    public String toString() {
        return ("Serie: " + this.getNombre() + "( " + this.getFechaDeLanzamiento()+ " )");
    }


  
}
