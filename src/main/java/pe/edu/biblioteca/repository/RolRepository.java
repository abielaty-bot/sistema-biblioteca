package pe.edu.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.biblioteca.entity.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {

}
