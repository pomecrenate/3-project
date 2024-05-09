package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

      System.out.println(businessItem.getBusinessItemName());

      return businessItem;
    } finally {
      JdbcUtil.close(rs);
      JdbcUtil.close(pstmt);
    }
  }
}
