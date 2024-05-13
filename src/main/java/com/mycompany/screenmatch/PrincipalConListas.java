/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.screenmatch;

import com.mycompany.modelos.Pelicula;
import com.mycompany.modelos.Serie;
import com.mycompany.modelos.Titulo;
import java.util.ArrayList;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Faby
 */
public class PrincipalConListas {
    
    public static void main(String[] args) {
        
        Pelicula peliOne = new Pelicula("Encanto", 2021);
        peliOne.evalua(7);
        Pelicula peliTwo = new Pelicula("Matrix", 1999);
        peliTwo.evalua(10);
        Serie casaDragon = new Serie("Casa del dragón", 2022);
        casaDragon.evalua(8);
        
        // es bueno programar orientado a interfaces,en este caso List es mas abstracto que arrayList, 
        //y es bueno que las referencias sean mas abstractas que la instanciacion, por si en un futuro queremos cambiar el objeto.
        //no se puede crear una instancia de List, porque es una interface.
        
        List<Titulo> lista = new ArrayList<>();
        
        lista.add(peliOne);
        lista.add(peliTwo);
        lista.add(casaDragon);
        
        for (Titulo titulo : lista) {
            System.out.println(" Titulo " + titulo.getNombre());
            
            if(titulo instanceof Pelicula pelicula){
            System.out.println(" La Clasificacion es : " + pelicula.getClasificacion());
        }
        }
        
        System.out.println(" El tamaño de la lista es : " + lista.size());
        System.out.println("La primera peli es : " + lista.get(0).getNombre());
        System.out.println("Lista Completa" + lista);
        System.out.println(" To String " + lista.get(0).toString());
        
        
        ArrayList<String>listaDeArtistas = new ArrayList<>();
        listaDeArtistas.add("Penélope Cruz");
        listaDeArtistas.add("Antonio Banderas");
        listaDeArtistas.add("Ricardo Darín");
        System.out.println("Lista Desordenada " + listaDeArtistas);
        
        
        //esto no se puede hacer con lista porque son objetos y no sabria que comparara porque tienen varios atributos.
        Collections.sort(listaDeArtistas);
        
        //despues de implementar el compareTo si se puede
        
        Collections.sort(lista);
        System.out.println("Lista de Titulos Ordenada " + lista);
        
        System.out.println("Lista Ordenada " + listaDeArtistas);
        
        lista.sort(Comparator.comparing(Titulo :: getFechaDeLanzamiento));
        System.out.println("Lista ordenada por fecha "+ lista);
    }
    
}
