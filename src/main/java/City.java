import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "city")

public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "city_id")
    private int cityId;
    @Column(name = "city_name")
    private String cityName;
    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
    private List<Employee> employee;

    public City(String cityName) {
        this.cityId = cityId;
        this.cityName = cityName;
        this.employee = employee;
    }

    public City() {

    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public List<Employee> getEmployee() {
        return employee;
    }

    @Override
    public String toString() {
        return "City{" +
                "city_id=" + cityId +
                ", city_name='" + cityName + '\'' +
                '}';
    }
}
