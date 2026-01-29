/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo.areopuerto.GUI;
import javax.swing.JOptionPane;
/**
 *
 * @author David Proaño
 */
public class Notificador {

    // Para mensajes de éxito (como crear un avión o definir aeropuerto)
    public static void info(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Éxito en la Operación", JOptionPane.INFORMATION_MESSAGE);
    }

    // Para errores (como IDs duplicados o fallos de persistencia)
    public static void error(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Error del Sistema", JOptionPane.ERROR_MESSAGE);
    }

    // Para advertencias (como slots ocupados)
    public static void advertencia(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Atención", JOptionPane.WARNING_MESSAGE);
    }
}

