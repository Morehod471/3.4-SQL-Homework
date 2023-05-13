import java.util.List;

public interface CityDAO {

    void mergeCity(City city);

    void saveCity(City city);

    void deleteCity(City city);

    void selectCity(City city, int a);
}
