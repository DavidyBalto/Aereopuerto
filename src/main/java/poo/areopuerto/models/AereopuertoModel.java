/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo.areopuerto.models;
import java.io.BufferedReader;

import java.io.FileNotFoundException; //no se donde va
import java.io.FileReader;

import java.io.IOException;


import poo.areopuerto.*;
/**
 *
 * @author David Proaño
 */
public class AereopuertoModel extends SCRUD {

    //Siempre cierrra el archivo para acabar de escribir   
    public AereopuertoModel() {

    }
    
    public void cargarDatos(){
        try (BufferedReader br = new BufferedReader(new FileReader("aereopuerto.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                Aereopuerto aereopuerto = new Aereopuerto(datos[0], Integer.parseInt(datos[1]), datos[2], datos[3], Integer.parseInt(datos[4]), Boolean.parseBoolean(datos[5]));
                agregar(aereopuerto.toString(), "aereopuerto.txt");
            }
        } catch (FileNotFoundException ex) {
            System.getLogger(AereopuertoModel.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } catch (IOException ex) {
            System.getLogger(AereopuertoModel.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
}
