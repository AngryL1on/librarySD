package ru.rutmiit.Library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.rutmiit.Library.entities.Librarian;
import ru.rutmiit.Library.entities.Reader;

import java.util.Optional;

public interface LibrarianRepository extends JpaRepository<Librarian, Integer> {
    Optional<Reader> findByName(String name);
    Optional<Reader> findByAddress(String address);
    Optional<Reader> findByEmail(String email);
    Optional<Reader> findByPhone(String phone);
}
