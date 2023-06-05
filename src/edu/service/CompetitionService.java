package edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import edu.entity.Building;
import edu.entity.Competition;
import edu.repository.CompetitionRepository;

import java.util.Arrays;
import java.util.List;

@Service
public class CompetitionService {
    @Autowired
    private CompetitionRepository competitionRepository;

    private static final List<String> SEARCHABLE_FIELDS = Arrays.asList("name");

    public Competition getCompetition(Integer id) {
        return competitionRepository.getCompetitionById(id);
    }

    /*public Object getAll(){
        return competitionRepository.getAll();
    }*/
    public List<Competition> getSomeCompetitions(Integer num) {
        Pageable limit = PageRequest.of(0, num);
        return competitionRepository.findAll(limit).getContent();
    }
    public List<Competition> getCompetitionByBuilding(Building building) {
        return competitionRepository.findCompetitionsByBuilding(building);
    }

    public List<Competition> searchCompetitions(String text, List<String> fields, int limit) {
        List<String> fieldsToSearchBy = fields.isEmpty() ? SEARCHABLE_FIELDS : fields;
        boolean containsInvalidField = fieldsToSearchBy.stream().anyMatch(f -> !SEARCHABLE_FIELDS.contains(f));
        if (containsInvalidField) {
            throw new IllegalArgumentException();
        }

        return competitionRepository.searchBy(
                text, limit, fieldsToSearchBy.toArray(new String[0]));
    }
}
