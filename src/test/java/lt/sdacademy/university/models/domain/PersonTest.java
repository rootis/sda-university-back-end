package lt.sdacademy.university.models.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PersonTest {

    @Test
    void getTitle() {
        String expectedTitle = "Age: 31, gender: MALE, name: Rutenis, surname: Turcinas";
        Person person = new Person(31, Gender.MALE, "Rutenis", "Turcinas");

        String result = person.getTitle();

        assertEquals(expectedTitle, result);
    }
}
