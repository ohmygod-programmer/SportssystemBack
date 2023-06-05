package edu.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import edu.data.SearchRequestDTO;
import edu.entity.Sportsman;
import edu.exceptions.NotFoundException;
import edu.service.SportsmansService;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
public class SportsmansController {
    @Autowired
    private SportsmansService sportsmansService;

    @GetMapping(value = "/sportsmans/{id}")
    public ResponseEntity<Sportsman> getSportsmanById(@PathVariable(name = "id") Integer id) throws NotFoundException {
        return new ResponseEntity<>(sportsmansService.getSportsman(id), HttpStatus.OK);
    }

    @PutMapping(value = "/sportsmans/{id}")
    public ResponseEntity changeSportsman(@PathVariable(name = "id") Integer id, Sportsman sportsman) {
        sportsmansService.putSportsman(sportsman);
        return ResponseHelper.getOkResponse();
    }
    @GetMapping(value = "/sportsmans/{id}/club")
    public ResponseEntity<Object> getSportsmansClub(@PathVariable(name = "id") Integer id) throws NotFoundException {
        Sportsman sportsman = sportsmansService.getSportsman(id);
        return ResponseHelper.getRedirectResponse(String.format("/club/%d", sportsman.getClub()));
    }

    @GetMapping(value = "/sportsmans/{id}/trainers")
    public ResponseEntity<Object> getSportsmansCoaches(@PathVariable(name = "id") Integer id) throws NotFoundException {
        return ResponseHelper.getRedirectResponse(String.format("/coaching/sportsman/%d", id));
    }


    @GetMapping(value = "/sportsmans/search")
            public List<Sportsman> searchSportsmans(SearchRequestDTO searchRequestDTO) {
        if (searchRequestDTO.getText().isEmpty()){
            int limit = searchRequestDTO.getLimit();
            if (limit<1){
                return new ArrayList<>();
            }
            return sportsmansService.getSomeSportsmans(limit);
        }
        System.out.println("Request for plant search received with edu.data : " + searchRequestDTO);

        return sportsmansService.searchSportsmans(searchRequestDTO.getText(), searchRequestDTO.getFields(), searchRequestDTO.getLimit());
    }


}
