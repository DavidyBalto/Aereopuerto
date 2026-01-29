/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo.areopuerto.controlers;

import poo.areopuerto.*;


import java.util.Map;
import java.util.HashMap;

/**
 * Controlador que gestiona los recursos de un aeropuerto específico.
 * Administra las colecciones de aviones, vuelos y aerolíneas asociadas a un aeropuerto.
 * Implementa la asignación automática de IDs para cada entidad usando contadores.
 *
 * @author David Proaño
 */
public class AereopuertoController {

   private Map<Integer, Aereolinea> aereolineas;
   private Map<Integer, Vuelo> vuelos;
   private Map<Integer, Avion> aviones;

   public static int idContadorAviones;
   public static int idContadorAerolineas;
   public static int idContadorVuelos;

    /**
     * Constructor que inicializa el controlador con colecciones vacías.
     * Inicializa los contadores de IDs en 1 para aviadores, aerolíneas y vuelos.
     */
    public AereopuertoController(){
        aereolineas = new HashMap<>();
        vuelos = new HashMap<>();
        aviones = new HashMap<>();
        idContadorAviones = 1;
        idContadorAerolineas = 1;
        idContadorVuelos = 1;
    }
   
    /**
     * Agrega un avión al controlador y le asigna automáticamente un ID único.
     *
     * @param a El avión a agregar
     */
    public void agregarAvion(Avion a){
        aviones.put(idContadorAviones, a);
        a.setId(idContadorAviones);
        idContadorAviones++;
    }

    public void actualizarAvion(Avion a){
        aviones.put(a.getId(), a);
    }
    
    public void actualizarAereolinea(Aereolinea a){
        aereolineas.put(a.getId(), a);
    }
    
    /**
     * Elimina un avión del controlador por su ID.
     *
     * @param id El ID del avión a eliminar
     */
    public void eliminarAvion(int id){
        aviones.remove(id);
    }
    
    /**
     * Obtiene un avión específico por su ID.
     *
     * @param id El ID del avión a obtener
     * @return El avión con el ID especificado, o null si no existe
     */
    public Avion getAvion(int id){
        return aviones.get(id);
        
    }
   
    /**
     * Agrega una aerolínea al controlador y le asigna automáticamente un ID único.
     *
     * @param a La aerolínea a agregar
     */
    public void agregarAerolinea(Aereolinea a){
        aereolineas.put(idContadorAerolineas, a);
        a.setId(idContadorAerolineas);
        idContadorAerolineas++;
    }
   
    /**
     * Agrega un vuelo al controlador y le asigna automáticamente un ID único.
     *
     * @param v El vuelo a agregar
     */
    public void agregarVuelo(Vuelo v){
        vuelos.put(idContadorVuelos, v);
        v.setId(idContadorVuelos);
        idContadorVuelos++;
    }
   
    /**
     * Elimina una aerolínea del controlador por su ID.
     *
     * @param id El ID de la aerolínea a eliminar
     */
    public void eliminarAerolinea(int id){
        aereolineas.remove(id);
    }
   
    /**
     * Elimina un vuelo del controlador por su ID.
     *
     * @param id El ID del vuelo a eliminar
     */
    public void eliminarVuelo(int id){
        vuelos.remove(id);
    }


    public Map<Integer, Aereolinea> getAereolineas() {
       return aereolineas;
   }

   public void setAereolineas(Map<Integer, Aereolinea> aereolineas) {
       this.aereolineas = aereolineas;
   }

   public Map<Integer, Vuelo> getVuelos() {
       return vuelos;
   }

   public void setVuelos(Map<Integer, Vuelo> vuelos) {
       this.vuelos = vuelos;
   }

   public Map<Integer, Avion> getAviones() {
       return aviones;
   }

   public void setAviones(Map<Integer, Avion> aviones) {
       this.aviones = aviones;
   }

   public static void setIdContadorAviones(int idContadorAviones) {
       AereopuertoController.idContadorAviones = idContadorAviones;
   }
   public static void setIdContadorAerolineas(int idContadorAerolineas) {
       AereopuertoController.idContadorAerolineas = idContadorAerolineas;
   }
   public static void setIdContadorVuelos(int idContadorVuelos) {
       AereopuertoController.idContadorVuelos = idContadorVuelos;
   }

}
