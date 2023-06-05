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
import edu.exceptions.NotFoundException;
import edu.service.BuildingsService;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
public class BuildingsController {
    @Autowired
    private BuildingsService buildingsService;

    @GetMapping(value = "/buildings/{id}")
    public ResponseEntity<Building> getBuildingById(@PathVariable(name = "id") Integer id) throws NotFoundException {
        return new ResponseEntity<>(buildingsService.getBuilding(id), HttpStatus.OK);
    }
    @GetMapping(value = "/buildings/{id}/competitions")
    public ResponseEntity<Object> getSportsmansCoaches(@PathVariable(name = "id") Integer id) throws NotFoundException {
        return ResponseHelper.getRedirectResponse(String.format("/competitions/building/%d", id));
    }
    @GetMapping(value = "/buildings/search")
    public List<Building> searchBuildings(SearchRequestDTO searchRequestDTO) {
        if (searchRequestDTO.getText().isEmpty()){
            int limit = searchRequestDTO.getLimit();
            if (limit<1){
                return new ArrayList<>();
            }
            return buildingsService.getSomeBuildings(limit);
        }
        System.out.println("Request for plant search received with edu.data : " + searchRequestDTO);

        return buildingsService.searchBuildings(searchRequestDTO.getText(), searchRequestDTO.getFields(), searchRequestDTO.getLimit());
    }
}
