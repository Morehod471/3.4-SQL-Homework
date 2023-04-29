import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    private final String user = "postgres";
    private final String password = "Badnis471merlion";
    private final String url = "jdbc:postgresql://localhost:5432/skypro";

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();

        try (final Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement =
                     connection.prepareStatement("SELECT * FROM employee")) {

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int idOfEmployee = resultSet.getInt("id");
                String firstNameOfEmployee = resultSet.getString("first_name");
                String lastNameOfEmployee = resultSet.getString("last_name");
                String genderOfEmployee = resultSet.getString("gender");
                String ageOfEmployee = resultSet.getString("age");
                int cityIdOfEmployee = resultSet.getInt("city_id");

//                System.out.println("Имя: " + firstNameOfEmployee);
//                System.out.println("Фамилия: " + lastNameOfEmployee);
//                System.out.println("Пол: " + genderOfEmployee);
//                System.out.println("Возраст: " + ageOfEmployee);
//                System.out.println("Город: " + cityIdOfEmployee);

                employees.add(new Employee(idOfEmployee, firstNameOfEmployee, lastNameOfEmployee, genderOfEmployee, ageOfEmployee, cityIdOfEmployee));
            }

        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к БД!");
            e.printStackTrace();
        }

        return employees;
    }

    @Override
    public Employee getEmployeeById(int id) {

        try (final Connection connection = DriverManager.getConnection(url, user, password)) {
             PreparedStatement statement =
                     connection.prepareStatement("SELECT * FROM employee WHERE id = " + id);

            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            int idOfEmployee = resultSet.getInt("id");
            String firstNameOfEmployee = resultSet.getString("first_name");
            String lastNameOfEmployee = resultSet.getString("last_name");
            String genderOfEmployee = resultSet.getString("gender");
            String ageOfEmployee = resultSet.getString("age");
            int cityIdOfEmployee = resultSet.getInt("city_id");

            return new Employee(idOfEmployee, firstNameOfEmployee, lastNameOfEmployee, genderOfEmployee, ageOfEmployee, cityIdOfEmployee);

        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к базе данных!");
            e.printStackTrace();
        }
        return null;
    }

        @Override
    public void createEmployee() {
        try (final Connection connection = DriverManager.getConnection(url, user, password)) {
            PreparedStatement statement =
                    connection.prepareStatement("INSERT INTO employee (first_name, last_name, gender, age, city_id) VALUES ('Peter', 'Jackson', 'Male', 41, 1)");
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateEmployee(int id) {
        try (final Connection connection = DriverManager.getConnection(url, user, password)) {
            PreparedStatement statement =
                    connection.prepareStatement("UPDATE employee SET first_name = 'Anton' WHERE id = " + id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteEmployee(int id) {
            try (final Connection connection = DriverManager.getConnection(url, user, password);
                 PreparedStatement statement =
                         connection.prepareStatement("DELETE FROM employee WHERE id = " + id)) {
                statement.executeUpdate();
            } catch (SQLException e) {
                System.out.println("Ошибка при подключении к БД!");
                e.printStackTrace();
            }
    }
}
