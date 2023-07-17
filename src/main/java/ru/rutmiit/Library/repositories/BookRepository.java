package ru.rutmiit.Library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.rutmiit.Library.entities.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
