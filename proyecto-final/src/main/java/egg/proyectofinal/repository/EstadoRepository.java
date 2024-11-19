package egg.proyectofinal.repository;  

import egg.proyectofinal.model.Estado;  
import org.springframework.data.jpa.repository.JpaRepository;  
import org.springframework.stereotype.Repository;  

@Repository  
public interface EstadoRepository extends JpaRepository<Estado, Long> {  
    // Aquí puedes agregar métodos personalizados si es necesario  
}