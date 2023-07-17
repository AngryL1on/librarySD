package ru.rutmiit.Library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.rutmiit.Library.entities.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
}
