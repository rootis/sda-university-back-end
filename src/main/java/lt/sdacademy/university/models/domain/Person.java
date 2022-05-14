package lt.sdacademy.university.models.domain;

public class Person extends Human {

    private String firstName;

    private String lastName;

    public Person(Integer age, Gender gender, String firstName, String lastName) {
        super(age, gender);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String getTitle() {
        return "";
    }

    public String getTitle(boolean nameOnly) {
        if (nameOnly) {
            return String.format("Name: %s, surname: %s", firstName, lastName);
        } else {
            return getTitle();
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
