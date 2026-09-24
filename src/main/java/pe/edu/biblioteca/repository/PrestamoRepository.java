package pe.edu.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.biblioteca.entity.Prestamo;

public interface PrestamoRepository extends JpaRepository<Prestamo, Long> {

}