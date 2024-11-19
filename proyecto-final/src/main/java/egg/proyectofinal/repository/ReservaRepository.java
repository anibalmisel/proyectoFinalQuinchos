/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package egg.proyectofinal.repository;

import egg.proyectofinal.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author 54113
 */
@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long>{

    
}
