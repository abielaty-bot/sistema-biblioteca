package pe.edu.biblioteca.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "libro_autor", uniqueConstraints = {
        @UniqueConstraint(name = "uk_libro_autor", columnNames = { "id_libro", "id_autor" })
})
public class LibroAutor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLibroAutor;

    @ManyToOne
    @JoinColumn(name = "id_libro", nullable = false)
    private Libro libro;

    @ManyToOne
    @JoinColumn(name = "id_autor", nullable = false)
    private Autor autor;

    public LibroAutor() {
    }

    public Long getIdLibroAutor() {
        return idLibroAutor;
    }

    public void setIdLibroAutor(Long idLibroAutor) {
        this.idLibroAutor = idLibroAutor;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
}