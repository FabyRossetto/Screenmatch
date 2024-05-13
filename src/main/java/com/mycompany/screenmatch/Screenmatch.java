/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.screenmatch;

import calculos.CalculadoraTiempo;
import calculos.FiltroRecomendaciones;
import com.mycompany.modelos.Episodio;
import com.mycompany.modelos.Pelicula;
import com.mycompany.modelos.Serie;
import java.util.ArrayList;

/**
 *
 * @author Faby
 */
public class Screenmatch {

    public static void main(String[] args) {
        Pelicula peliOne= new Pelicula("Encanto", 2021);
        peliOne.setDuracionEnMinutos(120);
        
        peliOne.muestraFichaTecnica();
        peliOne.evalua(8);
        peliOne.evalua(10);
       
        System.out.println("El total de las evaluaciones es " + peliOne.getTotalDeEvaluaciones());
        System.out.println("La calificacion de la pelicula es " + peliOne.calculaMedia());
        
        Pelicula peliTwo= new Pelicula("Matrix", 1999);
        peliTwo.setDuracionEnMinutos(120);
        
        peliTwo.muestraFichaTecnica();
        
        ArrayList <Pelicula> lista = new ArrayList<>();
        lista.add(peliOne);
        lista.add(peliTwo);
       
        
        System.out.println(" El tamaño de la lista es : " + lista.size());
        System.out.println("La primera peli es : " + lista.get(0).getNombre());
        System.out.println("Lista Completa" + lista);
        System.out.println(" To String " + lista.get(0).toString());
        
        
        
        Serie casaDragon= new Serie("Casa del dragón",2022);
        casaDragon.setTemporadas(1);
        casaDragon.setMinutosPorEpisodio(50);
        casaDragon.setEpisodiosPorTemporada(10);
        casaDragon.muestraFichaTecnica();
        
        System.out.println(" La serie es " + casaDragon.getNombre());
        
        System.out.println(casaDragon.getDuracionEnMinutos());
        
        CalculadoraTiempo calculadora= new CalculadoraTiempo();
         calculadora.incluye(peliTwo);
         calculadora.incluye(casaDragon);
         calculadora.incluye(peliOne);
        System.out.println(" Tiempo necesario para ver todos tus titulos : " +  calculadora.getTiempoTotal());
        
        FiltroRecomendaciones filtrar = new FiltroRecomendaciones();
        filtrar.filtra(peliOne);
        
        Episodio epi= new Episodio();
        epi.setNombre("Dragon uno");
        epi.setNumero(1);
        epi.setSerie(casaDragon);
        epi.setTotalVisualizaciones(50);
        
        filtrar.filtra(epi);
}
}
