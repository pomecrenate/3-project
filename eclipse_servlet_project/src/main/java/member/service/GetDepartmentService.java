package member.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import exception.DepartmentNotFoundException;
import jdbc.connection.ConnectionProvider;
import member.dao.DepartmentDao;

public class GetDepartmentService {
  private DepartmentDao departmentDao = new DepartmentDao();

  public Map<Integer, String> get() {
    try (Connection conn = ConnectionProvider.getConnection()) {
      Map<Integer, String> departments = departmentDao.selectAll(conn);

      if (departments.isEmpty()) {
        throw new DepartmentNotFoundException();
      }

      return departments;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
