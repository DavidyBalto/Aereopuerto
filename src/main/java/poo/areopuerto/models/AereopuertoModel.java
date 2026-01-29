/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo.areopuerto.models;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException; //no se donde va
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;

import poo.areopuerto.*;

/**
 * Modelo para la persistencia de datos del sistema de aeropuerto
 * Gestiona la carga y guardado de aeropuertos, aviones, vuelos y aerolíneas
 *
 * @author David Proaño
 */
public class AereopuertoModel {
    public static final String AEREOPUERTOS_FILE = "src/files/Aereopuertos.txt";
    public static final String AVIONES_FILE = "src/files/Aviones.txt";
    public static final String VUELOS_FILE = "src/files/Vuelos.txt";
    public static final String AEROLINEAS_FILE = "src/files/Aerolineas.txt";
    
    // Referencia a los aeropuertos para crear vuelos con objetos
    private Map<Integer, Aereopuerto> aereopuertosCache;
    //Siempre cierrra el archivo para acabar de escribir   
    
    /**
     * Carga todos los aeropuertos desde el archivo de persistencia.
     * Lee el archivo CSV y crea objetos Aereopuerto con sus IDs.
     * Maneja excepciones de archivo no encontrado o errores de I/O.
     *
     * @return Map con los aeropuertos cargados (id, Aereopuerto), o null si hay error
     */
    public Map<Integer, Aereopuerto> cargarAereopuertos(){
        try (BufferedReader br = new BufferedReader(new FileReader(AEREOPUERTOS_FILE))) {
            String linea;
            Map<Integer, Aereopuerto> aereopuertos = new HashMap<>();
            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty()) continue; // Ignorar líneas vacías
                String[] datos = linea.split(";");
                int id = Integer.parseInt(datos[0]);
                Aereopuerto aereopuerto = new Aereopuerto(datos[1], Integer.parseInt(datos[2]), datos[3], datos[4], Integer.parseInt(datos[5]), Boolean.parseBoolean(datos[6]));
                aereopuerto.setId(id); // ← Establecer el id
                aereopuertos.put(id, aereopuerto);
            }
            return aereopuertos;
        } catch (FileNotFoundException ex) {
            System.getLogger(AereopuertoModel.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } catch (IOException ex) {
            System.getLogger(AereopuertoModel.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return null;
    }

    /**
     * Guarda todos los aeropuertos en el archivo de persistencia.
     * Escribe cada aeropuerto en formato CSV con su ID como prefijo.
     *
     * @param aereopuertos Map de aeropuertos a guardar (id, Aereopuerto)
     */
    public void escribirAereopuertos(Map<Integer, Aereopuerto> aereopuertos){
        try{
            BufferedWriter br = new BufferedWriter(new FileWriter(AEREOPUERTOS_FILE));
            for (Map.Entry<Integer, Aereopuerto> entry : aereopuertos.entrySet()) {
                br.write(entry.getKey() + ";" + entry.getValue().toString()+"\n");
            }
            br.close();
        } catch (IOException ex) {
            System.getLogger(AereopuertoModel.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
    
    /**
     * Carga todos los aviones desde el archivo de persistencia.
     * Lee el archivo CSV y detecta el tipo de avión (AvionDeCarga o AvionPasajeros).
     * Crea instancias apropiadas según el tipo indicado en el archivo.
     *
     * @return Map con los aviones cargados (id, Avion), o null si hay error
     */
    public boolean cargarAviones(Map<Integer, Aereopuerto> aereopuertos){
        try (BufferedReader br = new BufferedReader(new FileReader(AVIONES_FILE))) {
            String linea;
            Map<Integer, Avion> aviones = new HashMap<>();
            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty()) continue; // Ignorar líneas vacías
                String[] datos = linea.split(";");
                int id = Integer.parseInt(datos[0]);
                int aereopuertoId = Integer.parseInt(datos[5]);
                int aereopuerto = aereopuertos.get(aereopuertoId).getId();
                
                if(datos[1].equals("AvionDeCarga")){
                    AvionDeCarga avion = new AvionDeCarga(datos[2], datos[3], datos[4], aereopuerto, Boolean.parseBoolean(datos[6]), Integer.parseInt(datos[7]));
                    aviones.put(id, avion);
                }
                if(datos[1].equals("AvionPasajeros")){
                    AvionPasajeros avion = new AvionPasajeros(datos[2], datos[3], datos[4], aereopuerto, Boolean.parseBoolean(datos[6]), Integer.parseInt(datos[7]));
                    aviones.put(id, avion);
                }
            }
            for (Avion a : aviones.values()) {
                aereopuertos.get(a.getAereopuertoId()).agregarAvion(a);
            }



        } catch (FileNotFoundException ex) {
            System.getLogger(AereopuertoModel.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } catch (IOException ex) {
            System.getLogger(AereopuertoModel.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return false;
    }
    
    /**
     * Guarda todos los aviones en el archivo de persistencia.
     * Escribe cada avión en formato CSV incluyendo su tipo (AvionDeCarga o AvionPasajeros).
     *
     * @param aviones Map de aviones a guardar (id, Avion)
     */
    public void escribirAviones(Map<Integer, Avion> aviones){
        try{
            BufferedWriter br = new BufferedWriter(new FileWriter(AVIONES_FILE));
            for (Map.Entry<Integer, Avion> entry : aviones.entrySet()) {
                br.write(entry.getKey() + ";" + entry.getValue().toString()+"\n");
            }
            br.close();
        } catch (IOException ex) {
            System.getLogger(AereopuertoModel.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
    
    /**
     * Carga todas las aerolíneas desde el archivo de persistencia.
     * Lee el archivo CSV y crea objetos Aereolinea con sus IDs.
     * El formato en archivo es: id;nombre;paisOrigen;codigo
     *
     * @return Map con las aerolíneas cargadas (id, Aereolinea), o null si hay error
     */
    public Map<Integer, Aereolinea> cargarAerolineas(){
        try (BufferedReader br = new BufferedReader(new FileReader(AEROLINEAS_FILE))) {
            String linea;
            Map<Integer, Aereolinea> aerolineas = new HashMap<>();
            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty()) continue; // Ignorar líneas vacías
                String[] datos = linea.split(";");
                int id = Integer.parseInt(datos[0]);
                Aereolinea aereolinea = new Aereolinea(datos[1], datos[2], datos[3]);
                aereolinea.setId(id);
                aerolineas.put(id, aereolinea);
            }
            return aerolineas;
        } catch (FileNotFoundException ex) {
            System.getLogger(AereopuertoModel.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } catch (IOException ex) {
            System.getLogger(AereopuertoModel.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return null;
    }
    
    /**
     * Guarda todas las aerolíneas en el archivo de persistencia.
     * Escribe cada aerolínea en formato CSV con su ID como prefijo.
     *
     * @param aerolineas Map de aerolíneas a guardar (id, Aereolinea)
     */
    public void escribirAerolineas(Map<Integer, Aereolinea> aerolineas){
        try{
            BufferedWriter br = new BufferedWriter(new FileWriter(AEROLINEAS_FILE));
            for (Map.Entry<Integer, Aereolinea> entry : aerolineas.entrySet()) {
                br.write(entry.getKey() + ";" + entry.getValue().toString()+"\n");
            }
            br.close();
        } catch (IOException ex) {
            System.getLogger(AereopuertoModel.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }    
    /**
     * Carga todos los vuelos desde el archivo de persistencia usando referencias a aeropuertos.
     * Lee el archivo CSV y recupera los aeropuertos de salida y llegada usando sus IDs.
     * Crea objetos Vuelo con los objetos Aereopuerto (no solo IDs).
     * Almacena una referencia a los aeropuertos en cache para llamadas posteriores.
     *
     * @param aereopuertos Map de aeropuertos para resolver referencias en los vuelos
     * @return Map con los vuelos cargados (id, Vuelo), o null si hay error
     */
    public Map<Integer, Vuelo> cargarVuelos(Map<Integer, Aereopuerto> aereopuertos){
        this.aereopuertosCache = aereopuertos; // Guardar referencia a aeropuertos
        try (BufferedReader br = new BufferedReader(new FileReader(VUELOS_FILE))) {
            String linea;
            Map<Integer, Vuelo> vuelos = new HashMap<>();
            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty()) continue; // Ignorar líneas vacías
                String[] datos = linea.split(";");
                int id = Integer.parseInt(datos[0]);
                String codigoVuelo = datos[1];
                int idAeroSalida = Integer.parseInt(datos[2]);
                int idAeroLlegada = Integer.parseInt(datos[3]);
                int idAvion = Integer.parseInt(datos[4]);
                
                // Obtener los aeropuertos por sus IDs
                Aereopuerto aeroSalida = aereopuertos.get(idAeroSalida);
                Aereopuerto aeroLlegada = aereopuertos.get(idAeroLlegada);
                
                if (aeroSalida != null && aeroLlegada != null) {
                    // Usar el constructor que recibe objetos Aereopuerto
                    Vuelo vuelo = new Vuelo(aeroSalida, aeroLlegada, idAvion, codigoVuelo);
                    vuelo.setId(id);
                    vuelos.put(id, vuelo);
                }
            }
            return vuelos;
        } catch (FileNotFoundException ex) {
            System.getLogger(AereopuertoModel.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } catch (IOException ex) {
            System.getLogger(AereopuertoModel.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return null;
    }
    
    /**
     * Carga todos los vuelos desde el archivo usando el cache de aeropuertos.
     * Método alternativo que proporciona una segunda opcion de carga hacia atrás.
     * Si no hay cache, carga los aeropuertos primero y luego los vuelos.
     *
     * @return Map con los vuelos cargados (id, Vuelo), o null si hay error
     */
    public Map<Integer, Vuelo> cargarVuelos(){
        if (this.aereopuertosCache != null) {
            return cargarVuelos(this.aereopuertosCache);
        }
        // Si no hay cache, cargar aeropuertos primero
        Map<Integer, Aereopuerto> aereopuertos = cargarAereopuertos();
        return cargarVuelos(aereopuertos);
    }
    
    /**
     * Guarda todos los vuelos en el archivo de persistencia evitando duplicados.
     * Actualiza vuelos existentes si han sido modificados y agrega nuevos.
     * Cambina vuelos existentes con los nuevos, dando prioridad a los nuevos (sobrescriben).
     *
     * @param vuelos Map de vuelos a guardar (id, Vuelo)
     */
    public void escribirVuelos(Map<Integer, Vuelo> vuelos){
        try{
            // Cargar vuelos existentes del archivo
            Map<Integer, String> vuelosExistentes = new HashMap<>();
            try (BufferedReader br = new BufferedReader(new FileReader(VUELOS_FILE))) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    if (linea.trim().isEmpty()) continue;
                    String[] datos = linea.split(";");
                    int id = Integer.parseInt(datos[0]);
                    vuelosExistentes.put(id, linea);
                }
            } catch (FileNotFoundException ex) {
                // El archivo no existe, continuamos sin vuelos existentes
            }
            
            // Crear mapa combinado: existentes + nuevos (nuevos sobrescriben)
            Map<Integer, String> vuelosCombinados = new HashMap<>(vuelosExistentes);
            
            // Agregar o actualizar con los nuevos vuelos
            for (Map.Entry<Integer, Vuelo> entry : vuelos.entrySet()) {
                String nuevoVuelo = entry.getKey() + ";" + entry.getValue().toString();
                vuelosCombinados.put(entry.getKey(), nuevoVuelo);
            }
            
            // Escribir todos los vuelos (combinados, sin duplicados, con actualizaciones)
            BufferedWriter bw = new BufferedWriter(new FileWriter(VUELOS_FILE));
            for (String linea : vuelosCombinados.values()) {
                bw.write(linea + "\n");
            }
            bw.close();
        } catch (IOException ex) {
            System.getLogger(AereopuertoModel.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
    
    /**
     * Verifica si un vuelo con el ID especificado ya existe en el archivo.
     * Útil para evitar duplicados al escribir vuelos desde múltiples aeropuertos.
     *
     * @param idVuelo El ID del vuelo a buscar
     * @return true si el vuelo ya existe, false en caso contrario
     */
    public boolean vueloExiste(int idVuelo){
        try (BufferedReader br = new BufferedReader(new FileReader(VUELOS_FILE))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty()) continue;
                String[] datos = linea.split(";");
                int id = Integer.parseInt(datos[0]);
                if (id == idVuelo) {
                    return true;
                }
            }
        } catch (FileNotFoundException ex) {
            // El archivo no existe, significa que no hay vuelos
            return false;
        } catch (IOException ex) {
            System.getLogger(AereopuertoModel.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return false;
    }
    
    /**
     * Verifica si un vuelo con el código especificado ya existe en el archivo.
     * Útil para evitar duplicados al escribir vuelos desde múltiples aeropuertos.
     *
     * @param codigoVuelo El código del vuelo a buscar (ej: "QUI-GYE-001")
     * @return true si el vuelo ya existe, false en caso contrario
     */
    public boolean vueloExistePorCodigo(String codigoVuelo){
        try (BufferedReader br = new BufferedReader(new FileReader(VUELOS_FILE))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty()) continue;
                String[] datos = linea.split(";");
                if (datos.length > 1 && datos[1].equals(codigoVuelo)) {
                    return true;
                }
            }
        } catch (FileNotFoundException ex) {
            // El archivo no existe, significa que no hay vuelos
            return false;
        } catch (IOException ex) {
            System.getLogger(AereopuertoModel.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return false;
    }
}
