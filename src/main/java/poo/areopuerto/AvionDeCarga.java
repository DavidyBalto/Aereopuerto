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
public class AvionDeCarga extends Avion{
    private int cantidadObjetos=0;
    private int pesoMaximo;
    private int peso=0;
    private ArrayList<String> obejtos= new ArrayList<>();

    public AvionDeCarga(String placa, String marca, String modelo, boolean enVuelo,  int pesoMaximo) {
        super(placa, marca, modelo, enVuelo);
        this.pesoMaximo = pesoMaximo;
    }

    public void agregarCarga(int p){
        cantidadObjetos+=1;
        peso+=p;
    }
    
    
    @Override
    public String toString() {
        return "AvionDeCarga{" + "cantidadObjetos=" + cantidadObjetos + ", pesoMaximo=" + pesoMaximo + ", peso=" + peso + ", obejtos=" + obejtos + '}';
    }
    
    
    
    
    
    
    
}
