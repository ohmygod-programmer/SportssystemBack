package edu.service;

        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.data.domain.PageRequest;
        import org.springframework.data.domain.Pageable;
        import org.springframework.stereotype.Service;
        import edu.entity.Trainer;
        import edu.exceptions.NotFoundException;
        import edu.repository.TrainersRepository;

        import java.util.Arrays;
        import java.util.List;

@Service
public class TrainersService {
    @Autowired
    private TrainersRepository trainersRepository;

    private static final List<String> SEARCHABLE_FIELDS = Arrays.asList("first_name","middle_name","last_name");

    public Trainer getTrainer(Integer id) throws NotFoundException {
        if (!trainersRepository.existsById(id))
            throw new NotFoundException("Sportsman not found");

        return trainersRepository.getTrainerById(id);
    }

    public List<Trainer> getSomeTrainers(Integer num) {
        Pageable limit = PageRequest.of(0, num);
        return trainersRepository.findAll(limit).getContent();
    }

    public List<Trainer> searchTrainers(String text, List<String> fields, int limit) {
        List<String> fieldsToSearchBy = fields.isEmpty() ? SEARCHABLE_FIELDS : fields;
        boolean containsInvalidField = fieldsToSearchBy.stream().anyMatch(f -> !SEARCHABLE_FIELDS.contains(f));
        if (containsInvalidField) {
            throw new IllegalArgumentException();
        }

        return trainersRepository.searchBy(text, limit, fieldsToSearchBy.toArray(new String[0]));
    }
}