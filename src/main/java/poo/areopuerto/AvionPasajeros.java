/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo.areopuerto;



/**
 * Clase que representa un avión de pasajeros.
 * Extiende la clase Avion e implementa funcionalidades específicas para transporte de pasajeros.
 * Gestiona la cantidad de pasajeros y la capacidad máxima.
 *
 * @author David Proaño
 */
public class AvionPasajeros extends Avion{
    private int cantidadPasajeros=0;
    private int capacidadPasajeros;
    //private ArrayList<String> pasajeros= new ArrayList<>();

    /**
     * Constructor que inicializa un avión de pasajeros con sus datos específicos.
     *
     * @param placa La placa/matrícula del avión
     * @param marca La marca del fabricante
     * @param modelo El modelo específico
     * @param aereopuerto El aeropuerto donde se encuentra el avión
     * @param enVuelo Indica si está en vuelo
     * @param capacidadPasajeros La cantidad máxima de pasajeros que puede transportar
     */
    public AvionPasajeros(String placa, String marca, String modelo, int aereopuerto, boolean enVuelo, int capacidadPasajeros) {
        super(placa, marca, modelo, aereopuerto, enVuelo);
        this.capacidadPasajeros = capacidadPasajeros;
    }
    
    /**
     * Convierte el avión de pasajeros a formato CSV para persistencia en archivo.
     *
     * @return String con los datos del avión de pasajeros
     */
    @Override
    public String toString() {
        return "AvionPasajeros;" + super.toString() + capacidadPasajeros + ";";
    }

    
    
    public int getCantidadPasajeros() {
        return cantidadPasajeros;
    }

    public void setCantidadPasajeros(int cantidadPasajeros) {
        this.cantidadPasajeros = cantidadPasajeros;
    }

    public int getCapacidadPasajeros() {
        return capacidadPasajeros;
    }

    public void setCapacidadPasajeros(int capacidadPasajeros) {
        this.capacidadPasajeros = capacidadPasajeros;
    }
}
