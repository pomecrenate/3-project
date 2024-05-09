package member.service;

import java.sql.Connection;
import java.sql.SQLException;
import exception.EmployeeNotFoundException;
import jdbc.connection.ConnectionProvider;
import member.dao.EmployeeDao;
import member.model.Employee;

public class ReadEmployeeService {
  private EmployeeDao employeeDao = new EmployeeDao();

  public Employee get(int code) {
    try (Connection conn = ConnectionProvider.getConnection()) {
      Employee employee = employeeDao.selectByCode(conn, code);

      if (employee == null) {
        throw new EmployeeNotFoundException();
      }

      return employee;
    } catch (SQLException e) {
      throw new RuntimeException();
    }
  }
}
