/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package egg.proyectofinal.repository;

import egg.proyectofinal.model.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author 54113
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{// cual es el objeto del repositorio y su primary key son los parametros
    
    @Query("FROM Usuario u WHERE u.nombre = ?1")
    public List<Usuario> findByNombre(String nombre);
}
