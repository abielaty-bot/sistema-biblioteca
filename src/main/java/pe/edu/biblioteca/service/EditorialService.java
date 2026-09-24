package pe.edu.biblioteca.service;

import java.util.List;

import org.springframework.stereotype.Service;

import pe.edu.biblioteca.entity.Editorial;
import pe.edu.biblioteca.repository.EditorialRepository;

@Service
public class EditorialService {

    private final EditorialRepository editorialRepository;

    public EditorialService(EditorialRepository editorialRepository) {
        this.editorialRepository = editorialRepository;
    }

    public List<Editorial> listarTodos() {
        return editorialRepository.findAll();
    }

    public Editorial guardar(Editorial editorial) {
        return editorialRepository.save(editorial);
    }

    public Editorial buscarPorId(Long id) {
        return editorialRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Editorial no encontrada"));
    }

    public Editorial actualizar(Long id, Editorial editorialActualizada) {
        Editorial editorial = buscarPorId(id);
        editorial.setNombre(editorialActualizada.getNombre());
        editorial.setPais(editorialActualizada.getPais());

        return editorialRepository.save(editorial);
    }

    public void eliminar(Long id) {
        Editorial editorial = buscarPorId(id);
        editorialRepository.delete(editorial);
    }
}