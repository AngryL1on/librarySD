package ru.rutmiit.Library.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

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
    protected Integer librarianId;

    @ManyToMany
    @JoinTable(
            name = "Registration",
            joinColumns = @JoinColumn( name = "librarianId"),
            inverseJoinColumns = @JoinColumn(name = "reader_id")
    )
    private Set<Reader> readers = new HashSet<>();

    public Librarian(String name, String email, String address, String phone, Integer librarianId) {
        super(name, email, address, phone);
        this.librarianId = librarianId;
    }

    public Librarian() {
    }

    public Set<Reader> getReaders() {
        return readers;
    }

    public void setReaders(Set<Reader> readers) {
        this.readers = readers;
    }

    public Integer getLibrarianId() {
        return librarianId;
    }

    public void setLibrarianId(Integer readerId) {
        this.librarianId = readerId;
    }

    @Override
    public String toString() {
        return "Librarian { librarianId=" + librarianId + ", name=" + name + ", address=" + address + ", phone="
                + phone + ", email=" + email + " }";
    }
}
