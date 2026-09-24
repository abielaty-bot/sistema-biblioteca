package pe.edu.biblioteca.service;

import java.util.List;

import org.springframework.stereotype.Service;

import pe.edu.biblioteca.entity.LibroAutor;
import pe.edu.biblioteca.repository.LibroAutorRepository;

@Service
public class LibroAutorService {

    private final LibroAutorRepository libroAutorRepository;

    public LibroAutorService(LibroAutorRepository libroAutorRepository) {
        this.libroAutorRepository = libroAutorRepository;
    }

    public List<LibroAutor> listarTodos() {
        return libroAutorRepository.findAll();
    }

    public LibroAutor guardar(LibroAutor libroAutor) {
        return libroAutorRepository.save(libroAutor);
    }

    public LibroAutor buscarPorId(Long id) {
        return libroAutorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Relación libro-autor no encontrada"));
    }

    public LibroAutor actualizar(Long id, LibroAutor datosActualizados) {
        LibroAutor libroAutor = buscarPorId(id);

        libroAutor.setLibro(datosActualizados.getLibro());
        libroAutor.setAutor(datosActualizados.getAutor());

        return libroAutorRepository.save(libroAutor);
    }

    public void eliminar(Long id) {
        LibroAutor libroAutor = buscarPorId(id);
        libroAutorRepository.delete(libroAutor);
    }
}