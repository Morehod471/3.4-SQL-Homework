import java.util.List;

public interface EmployeeDAO {

    List<Employee> getAllEmployee();
    Employee getEmployeeById(int id);
    void createEmployee(Employee employee);
    void updateEmployee(Employee employee, int id);
    void deleteEmployee(int id);
}


