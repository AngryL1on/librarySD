package ru.rutmiit.Library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.rutmiit.Library.entities.RentalBook;

@Repository
public interface RentalRepository extends JpaRepository<RentalBook, Integer> {
}
