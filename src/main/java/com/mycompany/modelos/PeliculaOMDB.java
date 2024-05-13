/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package com.mycompany.modelos;

/**Es un DTO que es la clase intermediaria que sea la responsable por comprender el json de una Api especifica,
 * y despues transferir los datos desde ese DTO a la clase verdadera,Pelicula.
 * El record tiene el objetivo de colocar datos y poder ver esos datos rapidamente. Ya tiene incorporados getters,setters y tostring.
 *
 * 
 */
public record PeliculaOMDB(String title, String year, String runtime) {

}
