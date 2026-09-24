package pe.edu.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.biblioteca.entity.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}