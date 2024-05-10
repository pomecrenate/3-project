package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import jdbc.JdbcUtil;
import member.model.BusinessType;

public class BusinessTypeDao {
  public BusinessType selectByCode(Connection conn, int code) throws SQLException {
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    System.out.println("business type code: " + code);

    try {
      pstmt = conn.prepareStatement("select * from business_type where business_type_code = ?");
      pstmt.setInt(1, code);
      rs = pstmt.executeQuery();

      BusinessType businessType = null;

      if (rs.next()) {
        int businessTypeCode = rs.getInt("business_type_code");
        String businessTypeName = rs.getString("business_type_name");

        businessType = new BusinessType(businessTypeCode, businessTypeName);
      }

      System.out.println(businessType.getBusinessTypeName());

      return businessType;
    } finally {
      JdbcUtil.close(rs);
      JdbcUtil.close(pstmt);
    }
  }

  public Map<Integer, String> selectAll(Connection conn) throws SQLException {
    String sql = "SELECT * FROM business_type";

    try (PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery()) {

      Map<Integer, String> businessTypes = new HashMap<>();

      while (rs.next()) {
        int code = rs.getInt("business_type_code");
        String name = rs.getString("business_type_name");
        businessTypes.put(code, name);
      }

      return businessTypes;
    }
  }
}
