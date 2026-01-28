/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo.areopuerto;

/**
 * Clase abstracta que representa un avión genérico del sistema.
 * Define las propiedades y comportamientos comunes a todos los tipos de aviones.
 * Esta clase es la base para AvionDeCarga y AvionPasajeros.
 *
 * @author David Proaño
 */
public abstract class Avion {
    private String placa;
    private String marca;
    private String modelo;
    private int id;
    //Esto es redundante, ya que el avion pertenece al aereopuertoController y no el aereopuerto al Avion
    //private Aereopuerto aereopuertoU;
    private boolean enVuelo;

    /**
     * Constructor que inicializa un avión con sus datos básicos.
     *
     * @param placa La placa/matrícula única del avión
     * @param marca La marca del fabricante (ej: "Boeing", "Airbus")
     * @param modelo El modelo específico del avión (ej: "747", "A380")
     * @param enVuelo Indica si el avión está actualmente en vuelo
     */
    public Avion(String placa, String marca, String modelo,/* Aereopuerto aereopuertoU,*/ boolean enVuelo) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        //this.aereopuertoU = aereopuertoU;
        this.enVuelo = enVuelo;
    }

    /**
     * Convierte el avión a formato CSV para persistencia en archivo.
     * El formato es: placa;marca;modelo;enVuelo;
     *
     * @return String con los datos del avión separados por punto y coma
     */
    @Override
    public String toString() {
        return placa + ";" + marca + ";" + modelo + ";" + enVuelo + ";";
    }


    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public boolean isEnVuelo() {
        return enVuelo;
    }

    public void setEnVuelo(boolean enVuelo) {
        this.enVuelo = enVuelo;
    }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}
