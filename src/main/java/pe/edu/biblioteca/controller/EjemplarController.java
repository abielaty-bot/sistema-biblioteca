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

import pe.edu.biblioteca.entity.Ejemplar;
import pe.edu.biblioteca.service.EjemplarService;

@RestController
@RequestMapping("/api/ejemplares")
public class EjemplarController {

    private final EjemplarService ejemplarService;

    public EjemplarController(EjemplarService ejemplarService) {
        this.ejemplarService = ejemplarService;
    }

    @GetMapping
    public List<Ejemplar> listarTodos() {
        return ejemplarService.listarTodos();
    }

    @GetMapping("/{id}")
    public Ejemplar buscarPorId(@PathVariable Long id) {
        return ejemplarService.buscarPorId(id);
    }

    @PostMapping
    public ResponseEntity<Ejemplar> guardar(
            @RequestBody Ejemplar ejemplar) {

        Ejemplar ejemplarGuardado = ejemplarService.guardar(ejemplar);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ejemplarGuardado);
    }

    @PutMapping("/{id}")
    public Ejemplar actualizar(
            @PathVariable Long id,
            @RequestBody Ejemplar ejemplar) {

        return ejemplarService.actualizar(id, ejemplar);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        ejemplarService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}