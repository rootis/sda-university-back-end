package lt.sdacademy.university.services;

import java.util.ArrayList;
import java.util.List;
import lt.sdacademy.university.models.University;
import org.springframework.stereotype.Service;

@Service
public class UniversityService {

    public List<University> getUniversities() {
        List<University> universities = new ArrayList<>();
        universities.add(new University(1, "KTU"));
        universities.add(new University(2, "SDA"));

        return universities;
    }
}
