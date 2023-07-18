package ru.rutmiit.Library.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "reader")
public class Reader extends Human {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(            name = "readerId"
    )
    protected Integer readerId;

    @ManyToOne
    @JoinColumn(name = "librarianId")
    private Librarian librarian;

    @OneToMany(mappedBy = "reader")
    private Set<RentalBook> rentalbooks = new HashSet<>();

    public Reader(Integer readerId, String name, String email, String address, String phoneNumber, Librarian librarian) {
        super(name, email, address, phoneNumber);
        this.readerId = readerId;
        this.librarian = librarian;
    }

    public Reader() {

    }

    public Librarian getLibrarian() {
        return librarian;
    }

    public void setLibrarian(Librarian librarian) {
        this.librarian = librarian;
    }

    public Set<RentalBook> getRentalbooks() {
        return rentalbooks;
    }

    public void setRentalbooks(Set<RentalBook> rentalbooks) {
        this.rentalbooks = rentalbooks;
    }

    public Integer getReaderId() {
        return readerId;
    }

    public void setReaderId(Integer readerId) {
        this.readerId = readerId;
    }

    @Override
    public String toString() {
        return "Reader { readerId=" + readerId + ", name=" + name + ", address=" + address + ", phoneNumber="
                + phoneNumber + ", email=" + email + " }";
    }
}
