package edu.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import edu.data.SearchRequestDTO;
import edu.entity.Trainer;
import edu.exceptions.NotFoundException;
import edu.service.TrainersService;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
public class TrainersController {
    @Autowired
    private TrainersService trainersService;

    @GetMapping(value = "/trainers/{id}")
    public ResponseEntity<Trainer> getTrainerById(@PathVariable(name = "id") Integer id) throws NotFoundException {
        return new ResponseEntity<>(trainersService.getTrainer(id), HttpStatus.OK);
    }
    @GetMapping(value = "/trainers/search")
    public List<Trainer> searchTrainers(SearchRequestDTO searchRequestDTO) {
        if (searchRequestDTO.getText().isEmpty()){
            int limit = searchRequestDTO.getLimit();
            if (limit<1){
                return new ArrayList<>();
            }
            return trainersService.getSomeTrainers(limit);
        }
        System.out.println("Request for plant search received with edu.data : " + searchRequestDTO);

        return trainersService.searchTrainers(searchRequestDTO.getText(), searchRequestDTO.getFields(), searchRequestDTO.getLimit());
    }

}
