package lt.sdacademy.university.controllers;

import java.util.List;
import lt.sdacademy.university.models.University;
import lt.sdacademy.university.services.UniversityService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/universities")
public class UniversityController {

    private final UniversityService universityService;

    public UniversityController(UniversityService universityService) {
        this.universityService = universityService;
    }

    @GetMapping
    public List<University> getAll() {
        return universityService.getUniversities();
    }

    @GetMapping("/{id}")
    public University getUniversity(@PathVariable Integer id) {
        return universityService.getUniversity(id);
    }
}
