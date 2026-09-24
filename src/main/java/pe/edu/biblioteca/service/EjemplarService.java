package pe.edu.biblioteca.service;

import java.util.List;

import org.springframework.stereotype.Service;

import pe.edu.biblioteca.entity.Ejemplar;
import pe.edu.biblioteca.repository.EjemplarRepository;

@Service
public class EjemplarService {

    private final EjemplarRepository ejemplarRepository;

    public EjemplarService(EjemplarRepository ejemplarRepository) {
        this.ejemplarRepository = ejemplarRepository;
    }

    public List<Ejemplar> listarTodos() {
        return ejemplarRepository.findAll();
    }

    public Ejemplar guardar(Ejemplar ejemplar) {
        return ejemplarRepository.save(ejemplar);
    }

    public Ejemplar buscarPorId(Long id) {
        return ejemplarRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ejemplar no encontrado"));
    }

    public Ejemplar actualizar(Long id, Ejemplar datosActualizados) {
        Ejemplar ejemplar = buscarPorId(id);

        ejemplar.setLibro(datosActualizados.getLibro());
        ejemplar.setCodigo(datosActualizados.getCodigo());
        ejemplar.setEstado(datosActualizados.getEstado());

        return ejemplarRepository.save(ejemplar);
    }

    public void eliminar(Long id) {
        Ejemplar ejemplar = buscarPorId(id);
        ejemplarRepository.delete(ejemplar);
    }
}