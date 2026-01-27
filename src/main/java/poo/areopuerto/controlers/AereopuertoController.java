/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo.areopuerto.controlers;

import poo.areopuerto.*;
import java.util.ArrayList;

/**
 *
 * @author David Proaño
 */
public class AereopuertoController {
    
   private ArrayList<Aereolinea> aereolineas;
   private ArrayList<Vuelo> vuelos;
   private ArrayList<Avion> aviones;
   
   public AereopuertoController(){
       aereolineas = new ArrayList<>();
       vuelos = new ArrayList<>();
       aviones = new ArrayList<>();
   }
   
   public void agregarAvion(Avion a){
       aviones.add(a);
   }
   
   public void eliminarAvion(Avion a){
       aviones.remove(a);
   }


   /*getters y setters*/
   public ArrayList<Aereolinea> getAereolineas() {
       return aereolineas;
   }

   public void setAereolineas(ArrayList<Aereolinea> aereolineas) {
       this.aereolineas = aereolineas;
   }

   public ArrayList<Vuelo> getVuelos() {
       return vuelos;
   }

   public void setVuelos(ArrayList<Vuelo> vuelos) {
       this.vuelos = vuelos;
   }

   public ArrayList<Avion> getAviones() {
       return aviones;
   }

   public void setAviones(ArrayList<Avion> aviones) {
       this.aviones = aviones;
   }
           
}
