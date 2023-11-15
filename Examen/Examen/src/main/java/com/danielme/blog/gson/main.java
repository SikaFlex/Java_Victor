package com.danielme.blog.gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class main {
    public static void main(String[] args) throws IOException {
            Gson lectura = new Gson();


        ej1(lectura);
        ej1(lectura);
    }

  
    public static void ej1 (Gson gson) {
        try {
               Hoteles hotel = gson.fromJson(new FileReader("Examen/src/resources/hotels.json"),
                                             Hoteles.class);

          for (Hotel hoteles : hotel.getHoteles()) {

            System.out.println(hoteles.getNombre());
            
          }
            
        } catch (JsonSyntaxException js) {
            System.err.println(js.getMessage());
        }
        catch(FileNotFoundException e){
            System.err.println(e.getMessage());

        }
       
    }
   
    public void ej2(Gson gson,Hotel newhotel){
        try {
            
            Hoteles objetoHoteles=null;
            objetoHoteles = gson.fromJson("Examen/src/resources/hotels_nous.json",
                                    Hoteles.class);
            Hotel[] hoteles = objetoHoteles.getHoteles();
            Hotel[] hotelesfinales = app
            
                                  
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
