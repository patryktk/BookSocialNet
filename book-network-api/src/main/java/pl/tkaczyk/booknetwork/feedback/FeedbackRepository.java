package pl.tkaczyk.booknetwork.feedback;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {

    @Query("""
        SELECT feedback
        from Feedback feedback
        where feedback.book.id = :bookId
        """)
    Page<Feedback> findAllByBookId(Long bookId, Pageable pageable);
}
