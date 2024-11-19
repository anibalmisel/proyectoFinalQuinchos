/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package egg.proyectofinal.model;

/**
 *
 * @author 54113
 */
public enum Servicio {
    COCHERA("Cochera"),
    PISCINA("Piscina"),
    PARRILLA("Parrilla"),
    INTERNET("Internet");

    private final String nombre;

    Servicio(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
