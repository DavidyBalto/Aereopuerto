/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo.areopuerto;

/**
 *
 * @author David Proaño
 */
public class Vuelo {
    private Aereopuerto aereopuertoSalida;
    private Aereopuerto aereopuertollegada;
    private Avion avion;
    private String obsrb="none";
    private int idVuelo=0;
    private String estado;  //programado, retrasado, finalizado, envuelo

    public Vuelo(Aereopuerto aereopuertoSalida, Aereopuerto aereopuertollegada, String obsrb, String estado, Avion avion) {
        this.aereopuertoSalida = aereopuertoSalida;
        this.aereopuertollegada = aereopuertollegada;
        this.obsrb = obsrb;
        this.estado = estado;
        idVuelo=idVuelo+1;
        this.avion=avion;
    }
    
    public Vuelo(Aereopuerto aereopuertoSalida, Aereopuerto aereopuertollegada,Avion avion){
        this.aereopuertoSalida = aereopuertoSalida;
        this.aereopuertollegada = aereopuertollegada;
        this.estado = "programado";
        idVuelo=idVuelo+1;
        this.avion=avion;    
    }

    public void retrasarVuelo(){
        if (estado.equals("finalizado")){
            return;
        }
        estado="retrasado";
    }
    public void iniciarVuelo(){
        if (estado.equals("finalizado")){
            return;
        }
        estado="enVuelo";
    }

    @Override
    public String toString() {
        return idVuelo + ";"+avion+";"+aereopuertoSalida + ";" + aereopuertollegada + ";" + obsrb + "'"  + estado;
    }
    
    
    public Aereopuerto getAereopuertoSalida() {
        return aereopuertoSalida;
    }

    public void setAereopuertoSalida(Aereopuerto aereopuertoSalida) {
        this.aereopuertoSalida = aereopuertoSalida;
    }

    public Aereopuerto getAereopuertollegada() {
        return aereopuertollegada;
    }

    public void setAereopuertollegada(Aereopuerto aereopuertollegada) {
        this.aereopuertollegada = aereopuertollegada;
    }

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    public String getObsrb() {
        return obsrb;
    }

    public void setObsrb(String obsrb) {
        this.obsrb = obsrb;
    }

    public int getIdVuelo() {
        return idVuelo;
    }

    public void setIdVuelo(int idVuelo) {
        this.idVuelo = idVuelo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    
    
    
    
    
}
