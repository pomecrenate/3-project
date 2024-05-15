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
  // 부서 코드로 부서 정보를 조회하는 메서드
  // 部門コードで部門情報を照会するメソッド
  public Department selectByCode(Connection conn, int code) throws SQLException {
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    System.out.println("department code: " + code);

    try {
      pstmt = conn.prepareStatement("SELECT * FROM department WHERE department_code = ?");
      pstmt.setInt(1, code);
      rs = pstmt.executeQuery();

      Department department = null;

      // ResultSet에서 결과를 추출하여 Department 객체 생성
      // ResultSetから結果を抽出してDepartmentオブジェクトを生成
      if (rs.next()) {
        int departmentCode = rs.getInt("department_code");
        String departmentName = rs.getString("department_name");

        department = new Department(departmentCode, departmentName);
      }

      // 생성된 Department 객체 반환
      // 生成されたDepartmentオブジェクトの返却
      return department;
    } finally {
      JdbcUtil.close(rs);
      JdbcUtil.close(pstmt);
    }
  }

  // 모든 부서 정보를 조회하는 메서드
  //すべての部門情報を照会するメソッド
  public Map<Integer, String> selectAll(Connection conn) throws SQLException {
    String sql = "SELECT * FROM department";

    try (PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery()) {

      Map<Integer, String> departments = new HashMap<>();

      // ResultSet에서 결과를 추출하여 Map에 저장
      // ResultSetから結果を抽出し、Mapに保存
      while (rs.next()) {
        int code = rs.getInt("department_code");
        String name = rs.getString("department_name");
        departments.put(code, name);
      }

      // 조회된 모든 부서 정보를 담은 Map 반환
      // 照会されたすべての部署情報を含むMap返却
      return departments;
    }
  }
}
