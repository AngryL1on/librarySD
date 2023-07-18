package ru.rutmiit.Library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.rutmiit.Library.entities.Reader;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReaderRepository extends JpaRepository<Reader, Long> {
    List<Reader> findByName(String name);
    Optional<Reader> findByAddress(String address);
    Optional<Reader> findByEmail(String email);
    Optional<Reader> findByphoneNumber(String phoneNumber);
}
