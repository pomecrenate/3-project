package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import jdbc.JdbcUtil;
import member.model.Department;

public class DepartmentDao {
  public Department selectByCode(Connection conn, int code) throws SQLException {
    PreparedStatement pstmt = null;
    ResultSet rs = null;

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
}
