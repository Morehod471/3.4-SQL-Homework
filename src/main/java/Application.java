public class Application {
    public static void main(String[] args) {

        EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();

        Employee employee1 = new Employee("John", "Week", "male", 48, 4);
        Employee employee2 = new Employee("Mark", "Shaw", "male", 15, 1);

        employeeDAO.getAllEmployee();

        employeeDAO.getEmployeeById(5);

        employeeDAO.createEmployee(employee1);

        employeeDAO.updateEmployee(employee2, 3);

        employeeDAO.deleteEmployee(2);

    }
}