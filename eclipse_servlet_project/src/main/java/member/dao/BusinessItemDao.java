package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import jdbc.JdbcUtil;
import member.model.BusinessItem;

public class BusinessItemDao {
  public BusinessItem selectByCode(Connection conn, int code) throws SQLException {
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    System.out.println("business item code: " + code);

    try {
      pstmt = conn.prepareStatement("select * from business_item where business_item_code = ?");
      pstmt.setInt(1, code);
      rs = pstmt.executeQuery();

      BusinessItem businessItem = null;

      if (rs.next()) {
        int businessItemCode = rs.getInt("business_item_code");
        String businessItemName = rs.getString("business_item_name");

        businessItem = new BusinessItem(businessItemCode, businessItemName);
      }

      return businessItem;
    } finally {
      JdbcUtil.close(rs);
      JdbcUtil.close(pstmt);
    }
  }

  public Map<Integer, String> selectAll(Connection conn) throws SQLException {
    String sql = "SELECT * FROM business_item";

    try (PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery()) {

      Map<Integer, String> businessItems = new HashMap<>();

      while (rs.next()) {
        int code = rs.getInt("business_item_code");
        String name = rs.getString("business_item_name");
        businessItems.put(code, name);
      }

      return businessItems;
    }
  }
}
