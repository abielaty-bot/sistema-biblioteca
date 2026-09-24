package pe.edu.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.biblioteca.entity.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long> {

}