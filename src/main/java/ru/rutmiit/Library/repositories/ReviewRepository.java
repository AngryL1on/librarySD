package ru.rutmiit.Library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.rutmiit.Library.entities.Review;

import java.util.List;
@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {

    @Query("SELECT rev FROM Review rev JOIN rev.reader r WHERE r.readerId = :readerId")
    List<Review> findByReader(@Param("readerId") int readerId);

}
