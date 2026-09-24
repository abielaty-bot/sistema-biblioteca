package pe.edu.biblioteca.service;

import java.util.List;

import org.springframework.stereotype.Service;

import pe.edu.biblioteca.entity.Autor;
import pe.edu.biblioteca.repository.AutorRepository;

@Service
public class AutorService {

    private final AutorRepository autorRepository;

    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    public List<Autor> listarTodos() {
        return autorRepository.findAll();
    }

    public Autor guardar(Autor autor) {
        return autorRepository.save(autor);
    }

    public Autor buscarPorId(Long id) {
        return autorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Autor no encontrado"));
    }

    public Autor actualizar(Long id, Autor autorActualizado) {
        Autor autor = buscarPorId(id);
        autor.setNombres(autorActualizado.getNombres());
        autor.setApellidos(autorActualizado.getApellidos());
        autor.setNacionalidad(autorActualizado.getNacionalidad());

        return autorRepository.save(autor);
    }

    public void eliminar(Long id) {
        Autor autor = buscarPorId(id);
        autorRepository.delete(autor);
    }
}