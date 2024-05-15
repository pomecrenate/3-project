package member.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import exception.EmployeeNotFoundException;
import jdbc.connection.ConnectionProvider;
import member.dao.EmployeeDao;

public class EmploymentTypeService {
  private EmployeeDao employeeDao = new EmployeeDao();

  public Map<String, Integer> get(int companyCode) {
    try (Connection conn = ConnectionProvider.getConnection()) {
      Map<String, Integer> typeCount = employeeDao.employmentType(conn, companyCode);

      if (typeCount.isEmpty()) {
        throw new EmployeeNotFoundException();
      }
      return typeCount;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

}
