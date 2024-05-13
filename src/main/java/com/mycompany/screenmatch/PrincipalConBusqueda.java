/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.screenmatch;

import Excepciones.ErrorEnConversionException;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.mycompany.modelos.PeliculaOMDB;
import com.mycompany.modelos.Titulo;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Faby
 */
public class PrincipalConBusqueda {

    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner scan = new Scanner(System.in);
        List<Titulo> titulos = new ArrayList<>();
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).setPrettyPrinting().create();

        while (true) { //este bucle es infinito. Hay que ponerle un break para que pueda salir.
            System.out.println("Escriba una pelicula: ");
            var busqueda = scan.next();

            if (busqueda.equalsIgnoreCase("Salir")) {
                break;
            }
            String direccion = "https://www.omdbapi.com/?t=" + busqueda + "&apikey=fb2f81f4";

            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(direccion))
                        .build();

                HttpResponse<String> response = client
                        .send(request, BodyHandlers.ofString());

                String json = response.body();
                System.out.println(json);

                PeliculaOMDB tituloomdb = gson.fromJson(json, PeliculaOMDB.class);
                System.out.println("Titulo " + tituloomdb);

                //llevar info de nuestro titulo OMDB a nuestro titulo:
                Titulo titulo = new Titulo(tituloomdb);
                System.out.println(" " + titulo);

                //Esto escribe un archivo txt
//            FileWriter escritura= new FileWriter("peliculas.txt");
//            escritura.write(titulo.toString());//paso el titulo a un string
//            escritura.close();//es importante cerrar la escritura, es como un canal que abrimos y cerramos.
                titulos.add(titulo);
            } catch (NumberFormatException e) {
                System.out.println("Ocurrió un error");
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Error en la URI, verifique la direccion");
            } catch (ErrorEnConversionException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println(titulos);

        FileWriter escritura = new FileWriter("titulos.json");
        escritura.write(gson.toJson(titulos));//paso la lista a json
        escritura.close();//es importante cerrar la escritura, es como un canal que abrimos y cerramos.
        System.out.println("Finalizó la ejecución del programa");

    }

}
