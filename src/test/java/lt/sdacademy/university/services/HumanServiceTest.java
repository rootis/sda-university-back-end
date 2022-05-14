package lt.sdacademy.university.services;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lt.sdacademy.university.models.domain.Gender;
import lt.sdacademy.university.models.domain.Human;
import lt.sdacademy.university.models.domain.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HumanServiceTest {

    private HumanService humanService;

    @BeforeEach
    void setUp() {
        humanService = new HumanService();
    }

    @Test
    void filterByGender() {
        List<Human> humans = new ArrayList<>();
        humans.add(new Person(28, Gender.FEMALE, "Margarita", "Kazlauskyte"));
        humans.add(new Person(14, Gender.MALE, "Gediminas", "Petronis"));
        humans.add(new Person(37, Gender.MALE, "Konstantinas", "Eimutis"));
        humans.add(new Person(18, Gender.FEMALE, "Greta", "Petrauskaite"));

        List<Human> result = humanService.filterByGender(Gender.MALE, humans);

        assertFalse(result.isEmpty());
        assertEquals(2, result.size());
        assertEquals(Gender.MALE, result.get(0).getGender());
        assertEquals(Gender.MALE, result.get(1).getGender());
    }

    @Test
    void filterByAge() {
        List<Human> humans = new ArrayList<>();
        humans.add(new Person(28, Gender.FEMALE, "Margarita", "Kazlauskyte"));
        humans.add(new Person(14, Gender.MALE, "Gediminas", "Petronis"));
        humans.add(new Person(37, Gender.MALE, "Konstantinas", "Eimutis"));
        humans.add(new Person(18, Gender.FEMALE, "Greta", "Petrauskaite"));

        List<Human> result = humanService.filterByAge(37, humans);

        assertFalse(result.isEmpty());
        assertEquals(1, result.size());
        assertEquals(Gender.MALE, result.get(0).getGender());
    }

    @Test
    void getNamesByGender() {
        List<Person> people = new ArrayList<>();
        people.add(new Person(28, Gender.FEMALE, "Margarita", "Kazlauskyte"));
        people.add(new Person(14, Gender.MALE, "Gediminas", "Petronis"));
        people.add(new Person(37, Gender.MALE, "Konstantinas", "Eimutis"));
        people.add(new Person(18, Gender.FEMALE, "Greta", "Petrauskaite"));

        List<String> result = humanService.getNamesByGender(Gender.MALE, people);

        assertFalse(result.isEmpty());
        assertEquals(2, result.size());
        assertEquals("Gediminas", result.get(0));
        assertEquals("Konstantinas", result.get(1));
    }

    @Test
    void groupByName() {
        List<Person> people = new ArrayList<>();
        people.add(new Person(28, Gender.FEMALE, "Margarita", "Kazlauskyte"));
        people.add(new Person(14, Gender.MALE, "Gediminas", "Petronis"));
        people.add(new Person(37, Gender.MALE, "Konstantinas", "Eimutis"));
        people.add(new Person(18, Gender.FEMALE, "Margarita", "Petrauskaite"));

        Map<String, List<Person>> result = humanService.groupByName(people);

        assertNotNull(result);
        assertEquals(3, result.entrySet().size());
        assertEquals(1, result.get("Gediminas").size());
        assertEquals(2, result.get("Margarita").size());
    }

    @Test
    void test() {
        List<Person> people = new ArrayList<>();
        people.add(new Person(28, Gender.FEMALE, "Margarita", "Kazlauskyte"));
        people.add(new Person(14, Gender.MALE, "Gediminas", "Petronis"));
        people.add(new Person(37, Gender.MALE, "Konstantinas", "Eimutis"));
        people.add(new Person(18, Gender.FEMALE, "Margarita", "Petrauskaite"));

        Map<Character, List<Person>> result = humanService.groupByFirstLetter(people);

        System.out.println(result);
    }

    @Test
    void getTheOldest() {
        List<Human> humans = new ArrayList<>();
        humans.add(new Person(28, Gender.FEMALE, "Margarita", "Kazlauskyte"));
        humans.add(new Person(14, Gender.MALE, "Gediminas", "Petronis"));
        humans.add(new Person(37, Gender.MALE, "Konstantinas", "Eimutis"));
        humans.add(new Person(18, Gender.FEMALE, "Greta", "Petrauskaite"));

        Human result = humanService.getTheOldest(humans);

        assertNotNull(result);
        assertEquals(Gender.MALE, result.getGender());
        assertEquals(37, result.getAge());
    }

    @Test
    void groupByGender() {
        List<Human> humans = new ArrayList<>();
        humans.add(new Person(28, Gender.FEMALE, "Margarita", "Kazlauskyte"));
        humans.add(new Person(14, Gender.MALE, "Gediminas", "Petronis"));
        humans.add(new Person(37, Gender.MALE, "Konstantinas", "Eimutis"));
        humans.add(new Person(18, Gender.FEMALE, "Greta", "Petrauskaite"));

        Map<Gender, List<Human>> result = humanService.groupByGender(humans);

        assertNotNull(result);
        assertEquals(2, result.entrySet().size());
        assertEquals(2, result.get(Gender.MALE).size());
        assertEquals(2, result.get(Gender.FEMALE).size());
    }
}
