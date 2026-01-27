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
public class Aereolinea {
     
    private String nombre;
    private String paisOrigen;
    private ArrayList<Avion> aviones= new ArrayList<>();
    private String codigo;

    public Aereolinea(String nombre, String codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
    }

    public void agregarAvion(Avion a){
        aviones.add(a);
    }

    @Override
    public String toString() {
        return nombre+";"+codigo+";"+aviones.toString();
    }
    
    /*getters y setters*/

    public String getPaisOrigen() {
        return paisOrigen;
    }

    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public ArrayList<Avion> getAviones() {
        return aviones;
    }

    public void setAviones(ArrayList<Avion> aviones) {
        this.aviones = aviones;
    }
    
    
    
    
    
}
