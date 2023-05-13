import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    static EntityManager readPersistent() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        return entityManager;
    }

    @Override
    public List<Employee> getAllEmployee() {
        EntityManager entityManager = readPersistent();
        String s = "SELECT e FROM Employee e";
        TypedQuery<Employee> query = entityManager.createQuery(s, Employee.class);
        List<Employee> employees = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return employees;
    }

    @Override
    public Employee getEmployeeById(int id) {
        EntityManager entityManager = readPersistent();
        Employee employee = entityManager.find(Employee.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return employee;
    }

        @Override
    public void createEmployee(Employee employee) {
            EntityManager entityManager = readPersistent();
            entityManager.persist(employee);
            entityManager.getTransaction().commit();
            entityManager.close();
    }

    @Override
    public void updateEmployee(Employee employee) {
        EntityManager entityManager = readPersistent();
        entityManager.merge(employee);
        entityManager.getTransaction().commit();
        entityManager.close();
    }


    @Override
    public void deleteEmployee(int id) {
        EntityManager entityManager = readPersistent();
        entityManager.remove(entityManager.find(Employee.class, id));
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
