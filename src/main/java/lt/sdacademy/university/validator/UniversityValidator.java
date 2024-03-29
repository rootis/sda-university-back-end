package lt.sdacademy.university.validator;

import java.util.HashMap;
import java.util.Map;
import lt.sdacademy.university.model.dto.University;
import lt.sdacademy.university.model.exception.ValidationException;
import lt.sdacademy.university.repository.UniversityRepository;
import org.springframework.stereotype.Component;

@Component
public class UniversityValidator {

    private final UniversityRepository universityRepository;

    public UniversityValidator(UniversityRepository universityRepository) {
        this.universityRepository = universityRepository;
    }

    public void validate(University university) {
        Map<String, String> errors = new HashMap<>();

        if (university == null) {
            errors.put("university", "university cannot be null");
            throw new ValidationException(errors);
        }

        validateCode(university, errors);
        validateTitle(university, errors);

        if (!errors.isEmpty()) {
            throw new ValidationException(errors);
        }
    }

    private void validateCode(University university, Map<String, String> errors) {
        if (university.getCode() == null) {
            errors.put("code", "code cannot be null");
            return;
        }

        String universityCode = university.getCode().trim();

        if (universityCode.length() < 2) {
            errors.put("code", "size must be between 2 and 10");
            return;
        }

        if (universityRepository.existsByCode(universityCode)) {
            errors.put("code", "such university already exists");
        }

        // TODO: validate first character not a number

        university.setCode(universityCode);
    }

    private void validateTitle(University university, Map<String, String> errors) {
        // TODO: validate - length, exists
    }
}
