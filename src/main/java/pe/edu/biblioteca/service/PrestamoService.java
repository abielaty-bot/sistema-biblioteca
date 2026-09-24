package pe.edu.biblioteca.service;

import java.util.List;

import org.springframework.stereotype.Service;

import pe.edu.biblioteca.entity.Prestamo;
import pe.edu.biblioteca.repository.PrestamoRepository;

@Service
public class PrestamoService {

    private final PrestamoRepository prestamoRepository;

    public PrestamoService(PrestamoRepository prestamoRepository) {
        this.prestamoRepository = prestamoRepository;
    }

    public List<Prestamo> listarTodos() {
        return prestamoRepository.findAll();
    }

    public Prestamo guardar(Prestamo prestamo) {
        return prestamoRepository.save(prestamo);
    }

    public Prestamo buscarPorId(Long id) {
        return prestamoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Prestamo no encontrado"));
    }

    public Prestamo actualizar(Long id, Prestamo datosActualizados) {
        Prestamo prestamo = buscarPorId(id);

        prestamo.setUsuario(datosActualizados.getUsuario());
        prestamo.setFechaPrestamo(datosActualizados.getFechaPrestamo());
        prestamo.setFechaLimite(datosActualizados.getFechaLimite());
        prestamo.setEstado(datosActualizados.getEstado());

        return prestamoRepository.save(prestamo);
    }

    public void eliminar(Long id) {
        Prestamo prestamo = buscarPorId(id);
        prestamoRepository.delete(prestamo);
    }
}