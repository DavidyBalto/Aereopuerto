/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo.areopuerto;

import java.util.ArrayList;

/**
 *
 * @author David Proaño
 */
public class AvionPasajeros extends Avion{
    private int cantidadPasajeros=0;
    private int capacidadPasajeros;
    private ArrayList<String> pasajeros= new ArrayList<>();

    public AvionPasajeros(String placa, String marca, String modelo, boolean enVuelo, int capacidadPasajeros) {
        super(placa, marca, modelo, enVuelo);
        this.capacidadPasajeros = capacidadPasajeros;
    }
    
    @Override
    public String toString() {
        return "AvionPasajeros{" + "cantidadPasajeros=" + cantidadPasajeros + ", capacidadPasajeros=" + capacidadPasajeros + ", pasajeros=" + pasajeros + '}';
    }
    
    /*getters y setters*/
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

    public ArrayList<String> getPasajeros() {
        return pasajeros;
    }

    public void setPasajeros(ArrayList<String> pasajeros) {
        this.pasajeros = pasajeros;
    }
    
    

}
