/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo.areopuerto;
import java.util.UUID;
/**
 *
 * @author David Proaño
 */
public class Avion {
    private String placa;
    private String marca;
    private String modelo;
    private Aereopuerto aereopuertoU;
    private boolean enVuelo;
    private static UUID idAvion= UUID.randomUUID();

    public Avion(String placa, String marca, String modelo, Aereopuerto aereopuertoU, boolean enVuelo, int idAvion) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.aereopuertoU = aereopuertoU;
        this.enVuelo = enVuelo;
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

    public Aereopuerto getAereopuertoU() {
        return aereopuertoU;
    }

    public void setAereopuertoU(Aereopuerto aereopuertoU) {
        this.aereopuertoU = aereopuertoU;
    }

    public boolean isEnVuelo() {
        return enVuelo;
    }

    public void setEnVuelo(boolean enVuelo) {
        this.enVuelo = enVuelo;
    }

    public static UUID getIdAvion() {
        return idAvion;
    }

    public static void setIdAvion(UUID idAvion) {
        Avion.idAvion = idAvion;
    }
    
    
    
                
            
}
