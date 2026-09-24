package pe.edu.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.biblioteca.entity.DetallePrestamo;

public interface DetallePrestamoRepository extends JpaRepository<DetallePrestamo, Long> {

}
