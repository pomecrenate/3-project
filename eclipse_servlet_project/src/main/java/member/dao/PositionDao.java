package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import jdbc.JdbcUtil;
import member.model.Position;

public class PositionDao {
  public Position selectByCode(Connection conn, int code) throws SQLException {
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    try {
      pstmt = conn.prepareStatement("select * from position where position_code = ?");
      pstmt.setInt(1, code);
      rs = pstmt.executeQuery();

      Position position = null;

      if (rs.next()) {
        int positionCode = rs.getInt("position_code");
        String positionName = rs.getString("position_name");

        position = new Position(positionCode, positionName);
      }

      return position;
    } finally {
      JdbcUtil.close(rs);
      JdbcUtil.close(pstmt);
    }
  }
}
