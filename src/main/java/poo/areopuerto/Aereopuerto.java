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
    
    private int id;
    private String nombre;
    private int avionesEn;
    private String pais;
    private String ciudad;
    private AereopuertoController controlador;
    private int capacidadAviones;
    private boolean esInternaional;  


    public Aereopuerto(String nombre, int avionesEn, String pais, String ciudad, int capacidadAviones, boolean esInternaional) {
        this.nombre = nombre;
        this.avionesEn = avionesEn;
        this.pais = pais;
        this.ciudad = ciudad;
        this.capacidadAviones = capacidadAviones;
        this.esInternaional = esInternaional;
        this.controlador = new AereopuertoController(); // ← Inicializar el controlador
    }   

    @Override
    public String toString() {
        return nombre + ";" + avionesEn + ";" + pais + ";" + ciudad + ";" + capacidadAviones + ";" + esInternaional;
    }


    

    public void agregarAvion(Avion a){
        avionesEn++;
        controlador.agregarAvion(a);
    }
    


    public void eliminarAvion(int id){
        avionesEn--;
        controlador.eliminarAvion(id);
    }
    
    // Métodos delegados para vuelos
    public void agregarVuelo(Vuelo v) {
        controlador.agregarVuelo(v);
    }
    
    public void eliminarVuelo(int id) {
        controlador.eliminarVuelo(id);
    }
    
    // Métodos delegados para aero líneas
    public void agregarAerolinea(Aereolinea a) {
        controlador.agregarAerolinea(a);
    }
    
    public void eliminarAerolinea(int id) {
        controlador.eliminarAerolinea(id);
    }
    
    // Métodos para acceder a los datos del controlador
    public java.util.Map<Integer, Avion> getAviones() {
        return controlador.getAviones();
    }
    
    public Avion getAvion(int id) {
        return controlador.getAvion(id);
    }
    
    public java.util.Map<Integer, Vuelo> getVuelos() {
        return controlador.getVuelos();
    }
    
    public java.util.Map<Integer, Aereolinea> getAerolineas() {
        return controlador.getAereolineas();
    }


    /*getters y setters*/
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
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



    /*
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
    */

}
