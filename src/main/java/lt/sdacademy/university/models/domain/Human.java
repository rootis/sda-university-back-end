package lt.sdacademy.university.models.domain;

public abstract class Human implements Beeing {

    private Integer age;

    private Gender gender;

    protected Human(Integer age, Gender gender) {
        this.age = age;
        this.gender = gender;
    }

    @Override
    public String getTitle() {
        return "";
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
