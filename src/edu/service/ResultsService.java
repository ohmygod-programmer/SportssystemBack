package edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.entity.*;
import edu.repository.ResultsRepository;

import java.util.List;

@Service
public class ResultsService {
    @Autowired
    ResultsRepository resultsRepository;

    public List<Result> findBySportsman(Sportsman sportsman){
        return resultsRepository.findBySportsman(sportsman);
    }

    public List<Result> findByCompetition(Competition competition){
        return resultsRepository.findByCompetition(competition);
    }
}
