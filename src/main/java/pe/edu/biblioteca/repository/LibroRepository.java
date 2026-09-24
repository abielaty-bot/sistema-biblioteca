package pe.edu.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.biblioteca.entity.Libro;

public interface LibroRepository extends JpaRepository<Libro, Long> {

}