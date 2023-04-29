import java.util.List;

public interface EmployeeDAO {

    List<Employee> getAllEmployees();
    Employee getEmployeeById(int id);
    void createEmployee();
    void updateEmployee(int id);
    void deleteEmployee(int id);
}


