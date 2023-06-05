package edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import edu.entity.Coaching;
import edu.exceptions.NotFoundException;
import edu.service.CoachingService;
import edu.service.SportsmansService;
import edu.service.TrainersService;

import java.util.List;

@RestController
public class CoachingController {
    @Autowired
    private CoachingService coachingService;
    @Autowired
    private SportsmansService sportsmansService;
    @Autowired
    private TrainersService trainersService;


    @GetMapping(value = "/coaching/sportsman/{id}")
    public ResponseEntity<List<Coaching>> getBySportsman(@PathVariable(name = "id") Integer id) throws NotFoundException {
        return new ResponseEntity<>(coachingService.findBySportsman(sportsmansService.getSportsman(id)), HttpStatus.OK);
    }
    @GetMapping(value = "/coaching/trainer/{id}")
    public ResponseEntity<List<Coaching>> getByTrainer(@PathVariable(name = "id") Integer id) throws NotFoundException {
        return new ResponseEntity<>(coachingService.findByTrainer(trainersService.getTrainer(id)), HttpStatus.OK);
    }

}
