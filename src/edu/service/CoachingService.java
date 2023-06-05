package edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.entity.Coaching;
import edu.entity.Sport;
import edu.entity.Sportsman;
import edu.entity.Trainer;
import edu.repository.CoachingRepository;

import java.util.List;

@Service
public class CoachingService {
    @Autowired
    private CoachingRepository coachingRepository;


    public List<Coaching> findBySportsman(Sportsman sportsman){
        return coachingRepository.findBySportsman(sportsman);
    }
    public List<Coaching> findByTrainer(Trainer trainer){
        return coachingRepository.findByTrainer(trainer);
    }
    public List<Coaching> findBySport(Sport sport){
        return coachingRepository.findBySport(sport);
    }


}
