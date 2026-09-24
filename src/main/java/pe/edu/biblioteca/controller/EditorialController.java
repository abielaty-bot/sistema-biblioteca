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

import pe.edu.biblioteca.entity.Editorial;
import pe.edu.biblioteca.service.EditorialService;

@RestController
@RequestMapping("/api/editoriales")
public class EditorialController {

    private final EditorialService editorialService;

    public EditorialController(EditorialService editorialService) {
        this.editorialService = editorialService;
    }

    @GetMapping
    public List<Editorial> listarTodos() {
        return editorialService.listarTodos();
    }

    @GetMapping("/{id}")
    public Editorial buscarPorId(@PathVariable Long id) {
        return editorialService.buscarPorId(id);
    }

    @PostMapping
    public ResponseEntity<Editorial> guardar(
            @RequestBody Editorial editorial) {

        Editorial editorialGuardada = editorialService.guardar(editorial);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(editorialGuardada);
    }

    @PutMapping("/{id}")
    public Editorial actualizar(
            @PathVariable Long id,
            @RequestBody Editorial editorial) {

        return editorialService.actualizar(id, editorial);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        editorialService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}