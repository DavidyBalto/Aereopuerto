/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo.areopuerto;

/**
 *
 * @author David Proaño
 */
public abstract class Avion {
    private String placa;
    private String marca;
    private String modelo;
    //Esto es redundante, ya que el avion pertenece al aereopuertoController y no el aereopuerto al Avion
    //private Aereopuerto aereopuertoU;
    private boolean enVuelo;
    private static int idAvion= 0;

    public Avion(String placa, String marca, String modelo,/* Aereopuerto aereopuertoU,*/ boolean enVuelo) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        //this.aereopuertoU = aereopuertoU;
        this.enVuelo = enVuelo;
        idAvion++;
    }

    @Override
    public String toString() {
        return "Avion{" +"idAvon"+idAvion+ "placa=" + placa + ", marca=" 
        + marca + ", modelo=" + modelo +/* ", aereopuertoU=" + aereopuertoU + */", enVuelo=" + enVuelo + '}';
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
    /*
    public Aereopuerto getAereopuertoU() {
        return aereopuertoU;
    }

    public void setAereopuertoU(Aereopuerto aereopuertoU) {
        this.aereopuertoU = aereopuertoU;
    }
    */
    public boolean isEnVuelo() {
        return enVuelo;
    }

    public void setEnVuelo(boolean enVuelo) {
        this.enVuelo = enVuelo;
    }

    public static int getIdAvion() {
        return idAvion;
    }


    
    

            
}
