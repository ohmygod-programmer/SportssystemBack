package edu.repository;

import org.springframework.stereotype.Repository;
import edu.entity.Building;

@Repository
public interface BuildingsRepository extends SearchRepository<Building, Integer> {
    public Building getBuildingById(Integer id);

    boolean existsById (Integer id);
}
