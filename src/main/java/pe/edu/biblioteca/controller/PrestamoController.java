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

import pe.edu.biblioteca.entity.Prestamo;
import pe.edu.biblioteca.service.PrestamoService;

@RestController
@RequestMapping("/api/prestamos")
public class PrestamoController {

    private final PrestamoService prestamoService;

    public PrestamoController(PrestamoService prestamoService) {
        this.prestamoService = prestamoService;
    }

    @GetMapping
    public List<Prestamo> listarTodos() {
        return prestamoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Prestamo buscarPorId(@PathVariable Long id) {
        return prestamoService.buscarPorId(id);
    }

    @PostMapping
    public ResponseEntity<Prestamo> guardar(
            @RequestBody Prestamo prestamo) {

        Prestamo prestamoGuardado = prestamoService.guardar(prestamo);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(prestamoGuardado);
    }

    @PutMapping("/{id}")
    public Prestamo actualizar(
            @PathVariable Long id,
            @RequestBody Prestamo prestamo) {

        return prestamoService.actualizar(id, prestamo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        prestamoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
