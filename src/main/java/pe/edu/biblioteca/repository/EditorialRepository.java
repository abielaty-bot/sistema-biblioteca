package pe.edu.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.biblioteca.entity.Editorial;

public interface EditorialRepository extends JpaRepository<Editorial, Long> {

}