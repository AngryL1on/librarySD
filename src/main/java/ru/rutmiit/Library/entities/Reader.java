package ru.rutmiit.Library.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "reader")
public class Reader extends Human {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "readerId"
    )
    protected Integer readerId;

    @ManyToMany(mappedBy = "readers")
    private Set<Librarian> librarians = new HashSet<>();

    @OneToMany(mappedBy = "reader")
    private Set<RentalBook> rentalbooks = new HashSet<>();

    public Reader(Integer readerId, String name, String email, String address, String phone) {
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

    public Integer getReaderId() {
        return readerId;
    }

    public void setReaderId(Integer readerId) {
        this.readerId = readerId;
    }

    @Override
    public String toString() {
        return "Reader { readerId=" + readerId + ", name=" + name + ", address=" + address + ", phone="
                + phone + ", email=" + email + " }";
    }
}
