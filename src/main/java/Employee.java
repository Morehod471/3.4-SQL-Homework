import javax.persistence.*;

@Entity
@Table(name = "employee")

public class Employee {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "gender")
    private String gender;
    @Column(name = "age")
    private int age;
    @Column(name = "city_id")
    private int cityId;

    public Employee() {

    }

    public Employee(String first_name, String last_name, String gender, int age, int city_id) {
        this.firstName = first_name;
        this.lastName = last_name;
        this.gender = gender;
        this.age = age;
        this.cityId = city_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public int getCityId() {
        return cityId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", first_name='" + firstName + '\'' +
                ", last_name='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", age='" + age + '\'' +
                ", city_id=" + cityId +
                '}';
    }
}
