import java.sql.*;
public class Application {
    public static void main(String[] args) throws SQLException {

        EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();
        employeeDAO.getAllEmployees().forEach(System.out::println);
        System.out.println();

        System.out.println(employeeDAO.getEmployeeById(5));
        System.out.println();

        employeeDAO.createEmployee();

        employeeDAO.getAllEmployees().forEach(System.out::println);
        System.out.println();

        employeeDAO.updateEmployee(7);

        employeeDAO.deleteEmployee(2);

        employeeDAO.getAllEmployees().forEach(System.out::println);
        System.out.println();
    }
}