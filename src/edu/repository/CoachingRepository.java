package edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import edu.entity.*;

import java.util.List;

@Repository
public interface CoachingRepository extends JpaRepository<Coaching, CoachingId> {
    List<Coaching> findBySportsman(Sportsman sportsman);
    List<Coaching> findByTrainer(Trainer trainer);
    List<Coaching> findBySport(Sport sport);
}