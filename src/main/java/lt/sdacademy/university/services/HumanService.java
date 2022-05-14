package lt.sdacademy.university.services;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lt.sdacademy.university.models.domain.Gender;
import lt.sdacademy.university.models.domain.Human;
import lt.sdacademy.university.models.domain.Person;

public class HumanService {

    public List<Human> filterByGender(Gender gender, List<Human> humans) {
        return new ArrayList<>();
    }

    public Human getTheOldest(List<Human> humans) {
        return humans.get(0);
    }

    public Map<Gender, List<Human>> groupByGender(List<Human> humans) {
        return new HashMap<>();
    }

    public List<Human> filterByAge(Integer age, List<Human> humans) {
        return new ArrayList<>();
    }

    public List<String> getNamesByGender(Gender gender, List<Person> people) {
        return new ArrayList<>();
    }

    public Map<Character, List<Person>> groupByFirstLetter(List<Person> people) {
        return new HashMap<>();
    }

    public Map<String, List<Person>> groupByName(List<Person> people) {
        return new HashMap<>();
    }
}
