package ru.rutmiit.Library.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(
        name = "Readers"
)
public class Reader extends Human {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "readerId"
    )
    protected Long readerId;

    @ManyToMany(mappedBy = "readers")
    private Set<Librarian> librarians = new HashSet<>();

    public Reader(Long readerId, String name, String email, String address, String phone) {
        super(name, email, address, phone);
        this.readerId = readerId;
    }

    public Reader() {

    }

    public Set<Librarian> getLibrarians() {
        return librarians;
    }

    public void setLibrarians(Set<Librarian> librarians) {
        this.librarians = librarians;
    }

    public Long getReaderId() {
        return readerId;
    }

    public void setReaderId(Long readerId) {
        this.readerId = readerId;
    }
}
