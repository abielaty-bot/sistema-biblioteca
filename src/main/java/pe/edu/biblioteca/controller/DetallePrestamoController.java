package pe.edu.biblioteca.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.biblioteca.entity.DetallePrestamo;
import pe.edu.biblioteca.service.DetallePrestamoService;

@RestController
@RequestMapping("/api/detalles-prestamo")
public class DetallePrestamoController {

    private final DetallePrestamoService detallePrestamoService;

    public DetallePrestamoController(
            DetallePrestamoService detallePrestamoService) {
        this.detallePrestamoService = detallePrestamoService;
    }

    @GetMapping
    public List<DetallePrestamo> listarTodos() {
        return detallePrestamoService.listarTodos();
    }

    @GetMapping("/{id}")
    public DetallePrestamo buscarPorId(@PathVariable Long id) {
        return detallePrestamoService.buscarPorId(id);
    }

    @PostMapping
    public ResponseEntity<DetallePrestamo> guardar(
            @RequestBody DetallePrestamo detallePrestamo) {

        DetallePrestamo detalleGuardado = detallePrestamoService.guardar(detallePrestamo);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(detalleGuardado);
    }

    @PutMapping("/{id}")
    public DetallePrestamo actualizar(
            @PathVariable Long id,
            @RequestBody DetallePrestamo detallePrestamo) {

        return detallePrestamoService.actualizar(id, detallePrestamo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        detallePrestamoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}