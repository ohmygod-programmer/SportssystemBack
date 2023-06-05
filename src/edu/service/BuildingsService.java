package edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import edu.entity.Building;
import edu.repository.BuildingsRepository;

import java.util.Arrays;
import java.util.List;

@Service
public class BuildingsService {
    @Autowired
    BuildingsRepository buildingsRepository;
    private static final List<String> SEARCHABLE_FIELDS = Arrays.asList("name", "address");
    public Building getBuilding(Integer id){
        return buildingsRepository.getBuildingById(id);
    }
    
    public List<Building> getSomeBuildings(Integer num){
        Pageable limit = PageRequest.of(0,num);
        return buildingsRepository.findAll(limit).getContent();
    }

    public List<Building> searchBuildings(String text, List<String> fields, int limit){
        List<String> fieldsToSearchBy = fields.isEmpty() ? SEARCHABLE_FIELDS : fields;
        boolean containsInvalidField = fieldsToSearchBy.stream(). anyMatch(f -> !SEARCHABLE_FIELDS.contains(f));
        if(containsInvalidField) {
            throw new IllegalArgumentException();
        }

        return buildingsRepository.searchBy(
                text, limit, fieldsToSearchBy.toArray(new String[0]));
    }
    
}
