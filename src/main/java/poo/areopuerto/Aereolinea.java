/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo.areopuerto;

/**
 * Clase que representa una aerolínea del sistema.
 * Almacena información básica de la aerolínea (nombre, país origen y código).
 * Las aerolíneas se distribuyen entre múltiples aeropuertos y no gestiona aviones directamente.
 * Esta clase funciona principalmente como información de referencia/decorativa en el sistema.
 *
 * @author David Proaño
 */
public class Aereolinea {
    private int id;
    private String nombre;
    private String paisOrigen;
    private String codigo;

    /**
     * Constructor principal que inicializa una aerolínea con todos sus datos.
     *
     * @param nombre El nombre de la aerolínea (ej: "TAME", "LATAM")
     * @param paisOrigen El país de origen/registro de la aerolínea (ej: "Ecuador", "Chile")
     * @param codigo El código IATA de 2 letras (ej: "LA", "TA")
     */
    public Aereolinea(String nombre, String paisOrigen, String codigo) {
        this.nombre = nombre;
        this.paisOrigen = paisOrigen;
        this.codigo = codigo;
    }

    /**
     * Constructor alternativo que solo requiere nombre y código.
     * Útil para compatibilidad con carga de archivos antiguos.
     * El país de origen se establece como "Desconocido".
     *
     * @param nombre El nombre de la aerolínea
     * @param codigo El código de la aerolínea
     */
    public Aereolinea(String nombre, String codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.paisOrigen = "Desconocido";
    }

    /**
     * Convierte la aerolínea a formato CSV para persistencia en archivo.
     * El formato es: nombre;paisOrigen;codigo
     *
     * @return String con los datos de la aerolínea separados por punto y coma
     */
    @Override
    public String toString() {
        return nombre + ";" + paisOrigen + ";" + codigo;
    }

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

    public String getPaisOrigen() {
        return paisOrigen;
    }

    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
