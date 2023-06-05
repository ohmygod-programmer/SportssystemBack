package edu.repository;

import edu.entity.Building;
import edu.entity.Competition;

import java.util.List;

public interface CompetitionRepository extends SearchRepository<Competition, Integer>{

    /*@Query(value="select * from competitions", nativeQuery=true)
    public Object getAll();*/

    public Competition getCompetitionById(Integer id);
    public List<Competition> findCompetitionsByBuilding(Building building);
    boolean existsById (Integer id);
}
