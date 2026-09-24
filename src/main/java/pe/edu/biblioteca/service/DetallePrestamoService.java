package pe.edu.biblioteca.service;

import java.util.List;

import org.springframework.stereotype.Service;

import pe.edu.biblioteca.entity.DetallePrestamo;
import pe.edu.biblioteca.repository.DetallePrestamoRepository;

@Service
public class DetallePrestamoService {

    private final DetallePrestamoRepository detallePrestamoRepository;

    public DetallePrestamoService(
            DetallePrestamoRepository detallePrestamoRepository) {
        this.detallePrestamoRepository = detallePrestamoRepository;
    }

    public List<DetallePrestamo> listarTodos() {
        return detallePrestamoRepository.findAll();
    }

    public DetallePrestamo guardar(DetallePrestamo detallePrestamo) {
        return detallePrestamoRepository.save(detallePrestamo);
    }

    public DetallePrestamo buscarPorId(Long id) {
        return detallePrestamoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Detalle de prestamo no encontrado"));
    }

    public DetallePrestamo actualizar(
            Long id,
            DetallePrestamo datosActualizados) {

        DetallePrestamo detallePrestamo = buscarPorId(id);

        detallePrestamo.setPrestamo(datosActualizados.getPrestamo());
        detallePrestamo.setEjemplar(datosActualizados.getEjemplar());
        detallePrestamo.setFechaDevolucion(
                datosActualizados.getFechaDevolucion());
        detallePrestamo.setEstado(datosActualizados.getEstado());

        return detallePrestamoRepository.save(detallePrestamo);
    }

    public void eliminar(Long id) {
        DetallePrestamo detallePrestamo = buscarPorId(id);
        detallePrestamoRepository.delete(detallePrestamo);
    }
}