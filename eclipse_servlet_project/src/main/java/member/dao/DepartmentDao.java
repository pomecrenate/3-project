package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import jdbc.JdbcUtil;
import member.model.Department;

public class DepartmentDao {
  public Department selectByCode(Connection conn, int code) throws SQLException {
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    System.out.println("department code: " + code);

    try {
      pstmt = conn.prepareStatement("select * from department where department_code = ?");
      pstmt.setInt(1, code);
      rs = pstmt.executeQuery();

      Department department = null;

      if (rs.next()) {
        int departmentCode = rs.getInt("department_code");
        String departmentName = rs.getString("department_name");

        department = new Department(departmentCode, departmentName);
      }

      return department;
    } finally {
      JdbcUtil.close(rs);
      JdbcUtil.close(pstmt);
    }
  }

  public Map<Integer, String> selectAll(Connection conn) throws SQLException {
    String sql = "SELECT * FROM department";

    try (PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery()) {

      Map<Integer, String> departments = new HashMap<>();

      while (rs.next()) {
        int code = rs.getInt("department_code");
        String name = rs.getString("department_name");
        departments.put(code, name);
      }

      return departments;
    }
  }
}
