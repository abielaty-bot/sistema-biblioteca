package pe.edu.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.biblioteca.entity.Ejemplar;

public interface EjemplarRepository extends JpaRepository<Ejemplar, Long> {

}
