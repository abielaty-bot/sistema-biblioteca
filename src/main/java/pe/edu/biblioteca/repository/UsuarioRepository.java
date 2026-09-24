package pe.edu.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.biblioteca.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}