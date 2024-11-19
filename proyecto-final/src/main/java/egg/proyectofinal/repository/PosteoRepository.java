/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package egg.proyectofinal.repository;

import egg.proyectofinal.model.Posteo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author user
 */
    @Repository
public interface PosteoRepository extends JpaRepository<Posteo, Integer>{// cual es el objeto del repositorio y su primary key son los parametros
    
    }