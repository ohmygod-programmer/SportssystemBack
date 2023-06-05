package edu.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;
import edu.entity.Trainer;

import java.util.List;

@Repository
public interface TrainersRepository extends SearchRepository<Trainer, Integer> {
    public Trainer getTrainerById(Integer id);
    boolean existsById (Integer id);

    List<Trainer> findAll(Specification<Trainer> sportsmanSpec, Pageable limit);
}
