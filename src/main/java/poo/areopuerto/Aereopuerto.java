/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package poo.areopuerto;


import poo.areopuerto.controlers.AereopuertoController;

/**
 *
 * @author David Proaño
 */
public class Aereopuerto {
    
    private String nombre;
    private int avionesEn;
    private String pais;
    private String ciudad;
    private AereopuertoController controlador;
    private int capacidadAviones;
    private boolean esInternaional;
    private static int idAereopuerto = 0;   


    public Aereopuerto(String nombre, int avionesEn, String pais, String ciudad, int capacidadAviones, boolean esInternaional) {
        this.nombre = nombre;
        this.avionesEn = avionesEn;
        this.pais = pais;
        this.ciudad = ciudad;
        this.capacidadAviones = capacidadAviones;
        this.esInternaional = esInternaional;
        idAereopuerto += 1 ;
    }   

    @Override
    public String toString() {
        return "Aereopuerto{" + "nombre=" + nombre + ", avionesEn=" + avionesEn + ", pais=" + pais + ", ciudad=" + ciudad + ", capacidadAviones=" + capacidadAviones + ", esInternaional=" + esInternaional + '}';
    }

    /*geters y setters*/
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAvionesEn() {
        return avionesEn;
    }

    public void setAvionesEn(int avionesEn) {
        this.avionesEn = avionesEn;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public AereopuertoController getControlador() {
        return controlador;
    }

    public void setControlador(AereopuertoController controlador) {
        this.controlador = controlador;
    }

    public int getCapacidadAviones() {
        return capacidadAviones;
    }

    public void setCapacidadAviones(int capacidadAviones) {
        this.capacidadAviones = capacidadAviones;
    }

    public boolean isEsInternaional() {
        return esInternaional;
    }

    public void setEsInternaional(boolean esInternaional) {
        this.esInternaional = esInternaional;
    }    
    
    public void agregarAvion(Avion a){
        avionesEn++;
        controlador.agregarAvion(a);
    }
    
    public void eliminarAvion(Avion a){
        avionesEn--;
        controlador.eliminarAvion(a);
    }

    public static int getIdAereopuerto() {
        return idAereopuerto;
    }


    /*
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
    */

}
