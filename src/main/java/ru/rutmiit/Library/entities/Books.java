package ru.rutmiit.Library.entities;


import jakarta.persistence.*;

@Entity
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;

    private String title;

    private String author;

    @Column(name = "publication_year")
    private Integer publicationYear;

    private String genre;


}
