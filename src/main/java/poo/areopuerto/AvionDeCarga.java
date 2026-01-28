/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo.areopuerto;


/**
 * Clase que representa un avión de carga.
 * Extiende la clase Avion e implementa funcionalidades específicas para transporte de carga.
 * Gestiona el peso total y la cantidad de objetos transportados.
 *
 * @author David Proaño
 */
public class AvionDeCarga extends Avion{
    private int cantidadObjetos=0;
    private int pesoMaximo;
    private int peso=0;
    //private int obejtos=0;
    /*Pendiente argegar clases obejtos  */

    /**
     * Constructor que inicializa un avión de carga con sus datos específicos.
     *
     * @param placa La placa/matrícula del avión
     * @param marca La marca del fabricante
     * @param modelo El modelo específico
     * @param enVuelo Indica si está en vuelo
     * @param pesoMaximo El peso máximo que puede transportar en kilogramos
     */
    public AvionDeCarga(String placa, String marca, String modelo, boolean enVuelo,  int pesoMaximo) {
        super(placa, marca, modelo, enVuelo);
        this.pesoMaximo = pesoMaximo;
    }

    /**
     * Agrega carga al avión incrementando el peso total y la cantidad de objetos.
     *
     * @param p El peso del objeto/carga a agregar en kilogramos
     */
    public void agregarCarga(int p){
        cantidadObjetos+=1;
        peso+=p;
    }
    
    /**
     * Convierte el avión de carga a formato CSV para persistencia en archivo.
     *
     * @return String con los datos del avión de carga
     */
    @Override
    public String toString() {
        return "AvionDeCarga;" + super.toString() + pesoMaximo + ";";
    }

    /**
     * Proporciona información legible del avión de carga con todos sus detalles.
     *
     * @return String con información completa del avión
     */
    public String informacionVuelo(){
        return "Avion de carga Placa: "+ this.getPlaca()+", Marca: "+ this.getMarca()+", Modelo: "+ this.getModelo()+", Peso Maximo: "+ this.pesoMaximo+", Peso Actual: "+ this.peso+", Cantidad de Objetos: "+ this.cantidadObjetos;
    }


    public int getPesoMaximo() {
        return pesoMaximo;
    }

    public void setPesoMaximo(int pesoMaximo) {
        this.pesoMaximo = pesoMaximo;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getCantidadObjetos() {
        return cantidadObjetos;
    }

    public void setCantidadObjetos(int cantidadObjetos) {
        this.cantidadObjetos = cantidadObjetos;
    }
    
}
