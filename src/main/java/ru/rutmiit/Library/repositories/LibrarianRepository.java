package ru.rutmiit.Library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.rutmiit.Library.entities.Librarian;

public interface LibrarianRepository extends JpaRepository<Librarian, Long> {
}
