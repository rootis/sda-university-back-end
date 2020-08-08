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

    public List<Human> getHumans() {
        List<Human> result = new ArrayList<>();

        result.add(new Person(28, Gender.FEMALE, "Margarita", "Kazlauskyte"));
        result.add(new Person(14, Gender.MALE, "Gediminas", "Petronis"));
        result.add(new Person(37, Gender.MALE, "Konstantinas", "Eimutis"));
        result.add(new Person(18, Gender.FEMALE, "Greta", "Petrauskaite"));

        return result;
    }

    public List<Human> filterByGender(Gender gender, List<Human> humans) {
        List<Human> result = new ArrayList<>();

        for (Human human : humans) {
            if (human.getGender().equals(gender)) {
                result.add(human);
            }
        }

        return result;
    }

    public Human getTheOldest(List<Human> humans) {
        Human result = null;
        int age = 0;

        for (Human human : humans) {
            if (human.getAge() > age) {
                age = human.getAge();
                result = human;
            }
        }

        return result;
    }

    public Map<Gender, List<Human>> groupByGender(List<Human> humans) {
        Map<Gender, List<Human>> result = new HashMap<>();

        for (Human human : humans) {
            if (!result.containsKey(human.getGender())) {
                result.put(human.getGender(), new ArrayList<>());
            }
            result.get(human.getGender()).add(human);
        }

        return result;
    }

    public List<Human> filterByAge(Integer age, List<Human> humans) {
        return humans.stream()
            .filter(h -> h.getAge().equals(age))
            .collect(toList());
    }

    public List<String> getNamesByGender(Gender gender, List<Person> people) {
        return people.stream()
            .filter(p -> p.getGender().equals(gender))
            .map(p -> p.getFirstName())
            .collect(toList());
    }

    public Map<Character, List<Person>> groupByFirstLetter(List<Person> people) {
        return people.stream()
            .collect(groupingBy(p -> p.getFirstName().charAt(0), toList()));
    }

    public Map<String, List<Person>> groupByName(List<Person> people) {
        return people.stream()
            .collect(groupingBy(Person::getFirstName));
    }
}
