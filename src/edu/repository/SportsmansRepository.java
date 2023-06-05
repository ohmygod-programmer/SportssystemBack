package edu.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;
import edu.entity.Sportsman;

import java.util.List;

@Repository
public interface SportsmansRepository extends SearchRepository<Sportsman, Integer> {
    public Sportsman getSportsmanById(Integer id);
    boolean existsById (Integer id);
    List<Sportsman> findAll(Specification<Sportsman> sportsmanSpec, Pageable limit);
}
