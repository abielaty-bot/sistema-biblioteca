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

import pe.edu.biblioteca.entity.LibroAutor;
import pe.edu.biblioteca.service.LibroAutorService;

@RestController
@RequestMapping("/api/libros-autores")
public class LibroAutorController {

    private final LibroAutorService libroAutorService;

    public LibroAutorController(LibroAutorService libroAutorService) {
        this.libroAutorService = libroAutorService;
    }

    @GetMapping
    public List<LibroAutor> listarTodos() {
        return libroAutorService.listarTodos();
    }

    @GetMapping("/{id}")
    public LibroAutor buscarPorId(@PathVariable Long id) {
        return libroAutorService.buscarPorId(id);
    }

    @PostMapping
    public ResponseEntity<LibroAutor> guardar(
            @RequestBody LibroAutor libroAutor) {

        LibroAutor registroGuardado = libroAutorService.guardar(libroAutor);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(registroGuardado);
    }

    @PutMapping("/{id}")
    public LibroAutor actualizar(
            @PathVariable Long id,
            @RequestBody LibroAutor libroAutor) {

        return libroAutorService.actualizar(id, libroAutor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        libroAutorService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}