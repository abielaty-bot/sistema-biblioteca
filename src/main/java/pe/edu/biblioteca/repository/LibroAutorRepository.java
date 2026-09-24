package pe.edu.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.biblioteca.entity.LibroAutor;

public interface LibroAutorRepository extends JpaRepository<LibroAutor, Long> {

}