package pe.edu.biblioteca.service;

import java.util.List;

import org.springframework.stereotype.Service;

import pe.edu.biblioteca.entity.Libro;
import pe.edu.biblioteca.repository.LibroRepository;

@Service
public class LibroService {

    private final LibroRepository libroRepository;

    public LibroService(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    public List<Libro> listarTodos() {
        return libroRepository.findAll();
    }

    public Libro guardar(Libro libro) {
        return libroRepository.save(libro);
    }

    public Libro buscarPorId(Long id) {
        return libroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Libro no encontrado"));
    }

    public Libro actualizar(Long id, Libro libroActualizado) {
        Libro libro = buscarPorId(id);

        libro.setCategoria(libroActualizado.getCategoria());
        libro.setEditorial(libroActualizado.getEditorial());
        libro.setTitulo(libroActualizado.getTitulo());
        libro.setIsbn(libroActualizado.getIsbn());
        libro.setAnioPublicacion(libroActualizado.getAnioPublicacion());
        libro.setEstado(libroActualizado.getEstado());

        return libroRepository.save(libro);
    }

    public void eliminar(Long id) {
        Libro libro = buscarPorId(id);
        libroRepository.delete(libro);
    }
}