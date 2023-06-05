package edu.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import edu.data.SearchRequestDTO;
import edu.entity.Building;
import edu.entity.Competition;
import edu.exceptions.NotFoundException;
import edu.service.BuildingsService;
import edu.service.CompetitionService;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
public class CompetitionsController {
    @Autowired
    private CompetitionService competitionService;
    @Autowired
    private BuildingsService buildingsService;
    /*@GetMapping(value = "/competitions")
    public ResponseEntity<Object> getAll(){
        return new ResponseEntity<>(competitionService.getAll(), HttpStatus.OK);
    }*/

    @GetMapping(value = "/competitions/{id}")
    public ResponseEntity<Competition> getCompetitionById(@PathVariable(name = "id") Integer id) throws NotFoundException {
        return new ResponseEntity<>(competitionService.getCompetition(id), HttpStatus.OK);
    }

    @GetMapping(value = "/competitions/building/{id}")
    public ResponseEntity<List<Competition>> getCompetitionByBuildingId(@PathVariable(name = "id") Integer id) throws NotFoundException {
        Building b = buildingsService.getBuilding(id);
        return new ResponseEntity<>(competitionService.getCompetitionByBuilding(b), HttpStatus.OK);
    }


    @GetMapping(value = "/competitions/search")
    public List<Competition> searchCompetitions(SearchRequestDTO searchRequestDTO) {
        if (searchRequestDTO.getText().isEmpty()) {
            int limit = searchRequestDTO.getLimit();
            if (limit < 1) {
                return new ArrayList<>();
            }
            return competitionService.getSomeCompetitions(limit);
        }
        System.out.println("Request for competition search received with edu.data: " + searchRequestDTO);

        return competitionService.searchCompetitions(searchRequestDTO.getText(), searchRequestDTO.getFields(), searchRequestDTO.getLimit());
    }
}

