package edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import edu.entity.Sportsman;
import edu.exceptions.NotFoundException;
import edu.repository.SportsmansRepository;

import java.util.Arrays;
import java.util.List;

@Service
public class SportsmansService {
    @Autowired
    private SportsmansRepository sportsmansRepository;

    private static final List<String> SEARCHABLE_FIELDS = Arrays.asList("first_name","middle_name","last_name");

    public Sportsman getSportsman(Integer id) throws NotFoundException {

        if (!sportsmansRepository.existsById(id))
            throw new NotFoundException("Sportsman not found");

        return sportsmansRepository.getSportsmanById(id);
    }

    public int putSportsman(Sportsman sportsman){
        /*if (!sportsmansRepository.existsById(sportsman.getId())){
            sportsmansRepository.save(sportsman);
        }
        else {
            sportsman.
        }*/
        if (sportsman.getClub() == null){
            sportsman.setClub(sportsmansRepository.getSportsmanById(sportsman.getId()).getClub());
        }
        if (sportsman.getDate_of_birth() == null){
            sportsman.setDate_of_birth(sportsmansRepository.getSportsmanById(sportsman.getId()).getDate_of_birth());
        }
        sportsmansRepository.save(sportsman);
        return 0;
    }

    public List<Sportsman> getSomeSportsmans(Integer num){
        Pageable limit = PageRequest.of(0,num);
        return sportsmansRepository.findAll(limit).getContent();
    }


    public List<Sportsman> searchSportsmans(String text, List<String> fields, int limit){
        List<String> fieldsToSearchBy = fields.isEmpty() ? SEARCHABLE_FIELDS : fields;
        boolean containsInvalidField = fieldsToSearchBy.stream(). anyMatch(f -> !SEARCHABLE_FIELDS.contains(f));
        if(containsInvalidField) {
            throw new IllegalArgumentException();
        }

        return sportsmansRepository.searchBy(
                text, limit, fieldsToSearchBy.toArray(new String[0]));
    }

}
