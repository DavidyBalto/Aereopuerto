/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo.areopuerto;

import java.time.LocalDateTime;


/**
 * Clase que representa un vuelo
 * @author David Proaño
 */
public class Vuelo {
    private int id;
    private String codigoVuelo;
    private int idAvion;
    private String observaciones;
    private String estado;  // Usar constantes: programado, retrasado, enVuelo, finalizado,cancelado
    private LocalDateTime horaSalida;
    private LocalDateTime horaLlegadaEstimada;
    private LocalDateTime horaLlegadaReal;
    private Aereopuerto aeroSalida;      // ← Referencia al aeropuerto de salida
    private Aereopuerto aeroLlegada;     // ← Referencia al aeropuerto de llegada

    /**
     * Constructor principal que crea un vuelo y lo auto-registra en ambos aeropuertos.
     * El vuelo se registra automáticamente en el controlador del aeropuerto de salida
     * y en el controlador del aeropuerto de llegada.
     *
     * @param aeroSalida El aeropuerto de origen del vuelo
     * @param aeroLlegada El aeropuerto de destino del vuelo
     * @param idAvion El ID del avión que operará este vuelo
     * @param codigoVuelo El código único del vuelo (ej: "QUI-GYE-001")
     */
    public Vuelo(Aereopuerto aeroSalida, Aereopuerto aeroLlegada, int idAvion, String codigoVuelo) {
        this.aeroSalida = aeroSalida;           // ← Guardar referencia
        this.aeroLlegada = aeroLlegada;         // ← Guardar referencia
        this.idAvion = idAvion;
        this.codigoVuelo = codigoVuelo;
        this.observaciones = "ninguna";
        this.estado = "programado";
        this.horaSalida = LocalDateTime.now();
        this.horaLlegadaEstimada = LocalDateTime.now().plusHours(3);
        
        // ← AUTO-REGISTRO EN AMBOS CONTROLADORES
        aeroSalida.agregarVuelo(this);
        aeroLlegada.agregarVuelo(this);
    }
    
    /**
     * Constructor alternativo que crea un vuelo usando solo IDs de aeropuertos.
     * Útil para cargar vuelos desde archivo sin auto-registrarse.
     * Este constructor NO registra el vuelo en los controladores automáticamente.
     * Los aeropuertos se establecen como null; deben asignarse después con los setters.
     *
     * @param idAeropuertoSalida El ID del aeropuerto de salida
     * @param idAeropuertoLlegada El ID del aeropuerto de llegada
     * @param idAvion El ID del avión que operará este vuelo
     * @param codigoVuelo El código único del vuelo
     */
    public Vuelo(int idAeropuertoSalida, int idAeropuertoLlegada, int idAvion, String codigoVuelo) {
        this.aeroSalida = null;                 // ← Se asignará después
        this.aeroLlegada = null;                // ← Se asignará después
        this.idAvion = idAvion;
        this.codigoVuelo = codigoVuelo;
        this.observaciones = "ninguna";
        this.estado = "programado";
        this.horaSalida = LocalDateTime.now();
        this.horaLlegadaEstimada = LocalDateTime.now().plusHours(3);
        // NOTA: Este constructor NO se auto-registra (usado solo en carga de archivo)
    }


    public Vuelo(Aereopuerto aeroSalida, Aereopuerto aeroLlegada, int idAvion, String codigoVuelo, String estado, LocalDateTime horaSalida, LocalDateTime horaLlegadaEstimada,String observaciones) {
        this.aeroSalida = aeroSalida;           // ← Guardar referencia
        this.aeroLlegada = aeroLlegada;         // ← Guardar referencia
        this.idAvion = idAvion;
        this.codigoVuelo = codigoVuelo;
        this.observaciones = observaciones;
        this.estado = estado;
        this.horaSalida = horaSalida;
        this.horaLlegadaEstimada = horaLlegadaEstimada;
        
        aeroSalida.agregarVuelo(this);
        aeroLlegada.agregarVuelo(this);
    }

    /**
     * Cambia el estado del vuelo a "retrasado" y registra el motivo.
     * Solo funciona si el vuelo no ha sido finalizado.
     *
     * @param motivo Descripción del motivo del retraso (ej: "Problema mecánico")
     */
    public boolean retrasarVuelo(String motivo) {
        if (!estado.equals("finalizado")|| estado.equals("enVuelo")) {
            this.estado = "retrasado";
            this.observaciones = motivo;
            return true;
        }
        return false;
    }

    public boolean cancelarVuelo(String motivo) {
        if (!estado.equals("finalizado")|| estado.equals("enVuelo")) {
            this.estado = "cancelado";
            this.observaciones = motivo;
            return true;
        }
        return false;
    }
    /**
     * Inicia el vuelo cambiando su estado a "enVuelo".
     * Registra la hora de salida actual.
     * Solo funciona si el vuelo no ha sido finalizado.
     */
    public boolean iniciarVuelo() {
        if (!estado.equals("finalizado")|| estado.equals("cancelado")) {
            this.estado = "enVuelo";
            this.horaSalida = LocalDateTime.now();
            return true;
        }
        return false;
    }

    /**
     * Finaliza el vuelo cambiando su estado a "finalizado".
     * Registra la hora de llegada real actual.
     * IMPORTANTE: Transfiere automáticamente el avión del aeropuerto de salida 
     * al aeropuerto de llegada (simula el aterrizaje del avión).
     * Solo funciona si el vuelo no ha sido finalizado previamente.
     */
    public boolean finalizarVuelo() {
        if (estado.equals("enVuelo")) {
            this.estado = "finalizado";
            this.horaLlegadaReal = LocalDateTime.now();
            
            // ← TRANSFERIR AVIÓN DE UN AEROPUERTO A OTRO
            if (aeroSalida != null && aeroLlegada != null) {
                // Obtener el avión del controlador de salida
                Avion avion = aeroSalida.getAvion(idAvion);
                
                if (avion != null) {
                    // Remover del aeropuerto de salida
                    aeroSalida.eliminarAvion(idAvion);
                    
                    // Agregar al aeropuerto de llegada
                    aeroLlegada.getControlador().agregarAvion(avion.getId(), avion);
                }
            }
            return true;
        }
        return false;
    }

    /**
     * Verifica si el vuelo puede despegar.
     * El vuelo puede despegar si su estado es "programado" o "retrasado".
     *
     * @return true si el vuelo puede despegar, false en caso contrario
     */
    public boolean puedeDecolar() {
        return estado.equals("programado") || estado.equals("retrasado");
    }

    /**
     * Convierte el vuelo a formato CSV para persistencia en archivo.
     * El formato es: codigoVuelo;idAeroSalida;idAeroLlegada;idAvion;estado;horaSalida;horaLlegadaEstimada;observaciones
     * Los IDs de aeropuertos se obtienen directamente de los objetos Aereopuerto.
     *
     * @return String con los datos del vuelo separados por punto y coma
     */
    @Override
    public String toString() {
        String delim = ";";
        
        // Obtener IDs desde los aeropuertos (si existen)
        int idSalida = (aeroSalida != null) ? aeroSalida.getId() : -1;
        int idLlegada = (aeroLlegada != null) ? aeroLlegada.getId() : -1;
        
        return codigoVuelo + delim + 
               idSalida + delim + 
               idLlegada + delim + 
               idAvion + delim + 
               estado + delim + 
               (horaSalida != null ? horaSalida.toString() : "N/A") + delim +
               (horaLlegadaEstimada != null ? horaLlegadaEstimada.toString() : "N/A") + delim +
               observaciones;
    }
    
    /**
     * Proporciona información legible del vuelo.
     *
     * @return String con los detalles principales del vuelo
     */
    public String informacionVuelo() {
        int idSalida = (aeroSalida != null) ? aeroSalida.getId() : -1;
        int idLlegada = (aeroLlegada != null) ? aeroLlegada.getId() : -1;
        return "Vuelo " + codigoVuelo + 
               " - Salida: " + idSalida + 
               ", Llegada: " + idLlegada + 
               ", Estado: " + estado +
               ", Avión ID: " + idAvion +
               ", Observaciones: " + observaciones;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigoVuelo() {
        return codigoVuelo;
    }

    public void setCodigoVuelo(String codigoVuelo) {
        this.codigoVuelo = codigoVuelo;
    }

    /**
     * Obtiene el ID del aeropuerto de salida desde el objeto Aereopuerto.
     *
     * @return El ID del aeropuerto de salida, o -1 si no hay aeropuerto asignado
     */
    public int getIdAeropuertoSalida() {
        return (aeroSalida != null) ? aeroSalida.getId() : -1;
    }

    /**
     * Obtiene el ID del aeropuerto de llegada desde el objeto Aereopuerto.
     *
     * @return El ID del aeropuerto de llegada, o -1 si no hay aeropuerto asignado
     */
    public int getIdAeropuertoLlegada() {
        return (aeroLlegada != null) ? aeroLlegada.getId() : -1;
    }


    public Aereopuerto getAeroSalida() {
        return aeroSalida;
    }

    public void setAeroSalida(Aereopuerto aeroSalida) {
        this.aeroSalida = aeroSalida;
    }

    public Aereopuerto getAeroLlegada() {
        return aeroLlegada;
    }


    public void setAeroLlegada(Aereopuerto aeroLlegada) {
        this.aeroLlegada = aeroLlegada;
    }

    public int getIdAvion() {
        return idAvion;
    }

    public void setIdAvion(int idAvion) {
        this.idAvion = idAvion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        if (estado.equals("programado") || 
            estado.equals("retrasado") || 
            estado.equals("enVuelo") || 
            estado.equals("finalizado")) {
            this.estado = estado;
        }
    }

    public LocalDateTime getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(LocalDateTime horaSalida) {
        this.horaSalida = horaSalida;
    }

    public LocalDateTime getHoraLlegadaEstimada() {
        return horaLlegadaEstimada;
    }

    public void setHoraLlegadaEstimada(LocalDateTime horaLlegadaEstimada) {
        this.horaLlegadaEstimada = horaLlegadaEstimada;
    }

    public LocalDateTime getHoraLlegadaReal() {
        return horaLlegadaReal;
    }

    public void setHoraLlegadaReal(LocalDateTime horaLlegadaReal) {
        this.horaLlegadaReal = horaLlegadaReal;
    }
}
