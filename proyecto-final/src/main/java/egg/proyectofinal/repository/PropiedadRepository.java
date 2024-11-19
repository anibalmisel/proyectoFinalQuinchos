package egg.proyectofinal.repository;

import egg.proyectofinal.model.Propiedad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para gestionar las operaciones de la entidad Propiedad.
 * Extiende JpaRepository para ofrecer CRUD básico.
 */
@Repository // Marca esta interfaz como un repositorio de Spring
public interface PropiedadRepository extends JpaRepository<Propiedad, Long> {
    // No es necesario implementar métodos CRUD, JpaRepository los proporciona automáticamente.
}
