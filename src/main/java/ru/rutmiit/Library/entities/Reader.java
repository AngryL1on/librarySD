package ru.rutmiit.Library.entities;

import jakarta.persistence.*;

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

    public Reader(Long readerId, String name, String email, String address, String phone) {
        super(name, email, address, phone);
        this.readerId = readerId;
    }

    public Reader() {

    }

    public Long getReaderId() {
        return readerId;
    }

    public void setReaderId(Long readerId) {
        this.readerId = readerId;
    }
}
