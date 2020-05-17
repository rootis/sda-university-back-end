package lt.sdacademy.university.controllers;

import lt.sdacademy.university.services.UniversityService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UniversityController {

    private final UniversityService universityService;

    public UniversityController(UniversityService universityService) {
        this.universityService = universityService;
    }

    @GetMapping
    public String getUniversities(Model model) {
        model.addAttribute("headerText", "SDA Lecture");
        model.addAttribute("title", "Universities");
        model.addAttribute("universities", universityService.getUniversities());

        return "universities";
    }
}
