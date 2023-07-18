package ru.rutmiit.Library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.rutmiit.Library.entities.Librarian;

import java.util.List;
import java.util.Optional;

public interface LibrarianRepository extends JpaRepository<Librarian, Integer> {
    List<Librarian> findByName(String name);
    Optional<Librarian> findByAddress(String address);
    Optional<Librarian> findByEmail(String email);
    Optional<Librarian> findByphoneNumber(String phoneNumber);
}
