package ru.rutmiit.Library.entities;

import jakarta.persistence.*;

@Entity
@Table(
        name = "Librarians"
)
public class Librarian extends Human {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "librarianId"
    )
    protected Long librarianId;

    public Librarian(String name, String email, String address, String phone, Long librarianId) {
        super(name, email, address, phone);
        this.librarianId = librarianId;
    }

    public Librarian() {
    }

    public Long getLibrarianId() {
        return librarianId;
    }

    public void setLibrarianId(Long readerId) {
        this.librarianId = readerId;
    }
}
