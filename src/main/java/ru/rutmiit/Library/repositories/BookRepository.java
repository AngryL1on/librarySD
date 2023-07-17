package ru.rutmiit.Library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.rutmiit.Library.entities.Book;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    Optional<Book> findByTitle(String title);

    Optional<Book> findByAutor(String author);

    Optional<Book> findByPublicationYear(Integer publicationYear);

    Optional<Book> findByGenre(String genre);
}
