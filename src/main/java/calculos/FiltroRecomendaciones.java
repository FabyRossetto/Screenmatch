/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calculos;

/**
 *
 * @author Faby
 */
public class FiltroRecomendaciones {
    
    
    public void filtra (Clasificacion clasificacion){
        if(clasificacion.getClasificacion() >=4){
            System.out.println("La puntuacion es alta");
        } else{
            System.out.println("La puntuacion podria ser mejor");
        }
    }
}
