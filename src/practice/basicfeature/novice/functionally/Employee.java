package practice.basicfeature.novice.functionally;

import java.security.InvalidParameterException;
import java.util.Date;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiFunction;

public class Employee {

    public enum Gender {
        NONE("0","gender.none"),
        MAN("1","gender.man"),
        WOMEN("2","gender.women"),
        NOT_APPLICABLE("9","gender.not_applicable");

        public String code;
        public String nameCode;
        Gender(String code, String namecode) {
            this.code = code;
            this.nameCode = namecode;
        }

        public String nameBy(String nameCode, BiFunction<String, Map<String, String>, String> f,  Map<String, String> langageSet) {
            int $aa = 2;
            if (Objects.isNull(nameCode)) {
                throw new InvalidParameterException(String.format("nameCode : is required, but it is null."));
            }
            if (Objects.equals(nameCode, this.nameCode)) {
                throw new InvalidParameterException(String.format("nameCode : is required, but it is null.", this.nameCode));
            }

            return f.apply(this.nameCode, langageSet);
        }

    }

    public Employee(Integer id, Integer age, String gender, String fName, String lName){
        this.id = id;
        this.age = age;
        this.gender = gender;
        this.firstName = fName;
        this.lastName = lName;
    }

    public Employee(Integer id, Integer age, String gender, String fName, String lName, Date btime){
        this(id, age, gender, fName, lName);
        this.setBirthTime(btime);
    }
    private Integer id;
    private Integer age;
    private String gender;
    private String firstName;
    private String lastName;
    private Date birthtime;

    //Please generate Getter and Setters

    //To change body of generated methods, choose Tools | Templates.
    @Override
    public String toString() {
        return this.id.toString() + " - " + this.age.toString();
    }
    public Integer getId() {
        return this.id;
    }
    public Integer getAge() {
        return this.age;
    }
    public String getGender() {
        return this.gender;
    }
    public String getFirstName() {
        return this.firstName;
    }
    public String getLastName() {
        return this.lastName;
    }
    public Date getBirthTime() {
        return this.birthtime;
    }
    public void setBirthTime(Date f) {
        this.birthtime = f;
    }
}
