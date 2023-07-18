package ru.rutmiit.Library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.rutmiit.Library.entities.Librarian;
import ru.rutmiit.Library.entities.Reader;
import ru.rutmiit.Library.entities.Review;

import java.util.List;
import java.util.Optional;
@Repository
public interface LibrarianRepository extends JpaRepository<Librarian, Integer> {
    List<Librarian> findByName(String name);
    Optional<Librarian> findByAddress(String address);
    Optional<Librarian> findByEmail(String email);
    Optional<Librarian> findByphoneNumber(String phoneNumber);

}
