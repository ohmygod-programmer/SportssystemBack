package edu.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import edu.entity.Competition;
import edu.entity.Result;
import edu.entity.Sportsman;
import edu.exceptions.NotFoundException;
import edu.service.CompetitionService;
import edu.service.ResultsService;
import edu.service.SportsmansService;

import java.util.List;

@Slf4j
@RestController
public class ResultsController {
    @Autowired
    ResultsService resultsService;
    @Autowired
    SportsmansService sportsmansService;
    @Autowired
    CompetitionService competitionService;

    @GetMapping(value = "/results/sportsman/{id}")
    public ResponseEntity<List<Result>> getResultBySportsmanId(@PathVariable(name = "id") Integer id) throws NotFoundException {
        Sportsman s = sportsmansService.getSportsman(id);
        return new ResponseEntity<>(resultsService.findBySportsman(s), HttpStatus.OK);
    }
    @GetMapping(value = "/results/competition/{id}")
    public ResponseEntity<List<Result>> getResultByCompetitionId(@PathVariable(name = "id") Integer id) throws NotFoundException {
        Competition competition = competitionService.getCompetition(id);
        return new ResponseEntity<>(resultsService.findByCompetition(competition), HttpStatus.OK);
    }
}
