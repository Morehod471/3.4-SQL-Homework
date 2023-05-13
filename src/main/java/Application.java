import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        EntityManager entityManager = createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        City city = new City("Nice");
        CityDAO cityDAO = new CityDAOImpl();

        Employee employee = new Employee("John", "Kahr", "men", 30, city);
        Employee employee1 = new Employee("Sam", "Wayne", "men", 22, city);
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();

        cityDAO.saveCity(city);
        employeeDAO.updateEmployee(employee);
        employeeDAO.updateEmployee(employee1);

        City city1 = entityManager.find(City.class, 2);
        List<Employee> employee2 = city1.getEmployee();
        Employee employee3 = employee2.get(1);
        employee3.setFirstName("Max");
        entityManager.merge(city1);

        City city2 = entityManager.find(City.class, 1);
        entityManager.remove(city2);

        transaction.commit();
        entityManager.close();
    }

    static EntityManager createEntityManager() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
        return entityManagerFactory.createEntityManager();
    }
}