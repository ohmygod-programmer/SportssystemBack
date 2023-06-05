package edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import edu.entity.*;

import java.util.List;

public interface ResultsRepository extends JpaRepository<Result, CoachingId> {
    List<Result> findBySportsman(Sportsman sportsman);
    List<Result> findByCompetition(Competition competition);
}
