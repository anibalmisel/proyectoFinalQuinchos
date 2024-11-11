/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package egg.proyectofinal.model;

import jakarta.persistence.Id;
import java.io.Serializable;

/**
 *
 * @author 54113
 */
public class UsuarioAux implements Serializable{
    
    private static final long serialVersionUID = 1l;
    
    private Long idRolSeleccionado;

    public Long getIdRolSeleccionado() {
        return idRolSeleccionado;
    }

    public void setIdRolSeleccionado(Long idRolSeleccionado) {
        this.idRolSeleccionado = idRolSeleccionado;
    }
    
    
}
