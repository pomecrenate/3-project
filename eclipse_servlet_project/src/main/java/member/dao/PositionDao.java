package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import jdbc.JdbcUtil;
import member.model.Position;

public class PositionDao {
  public Position selectByCode(Connection conn, int code) throws SQLException {
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    System.out.println("position code: " + code);

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

      System.out.println(position.getPositionName());

      return position;
    } finally {
      JdbcUtil.close(rs);
      JdbcUtil.close(pstmt);
    }
  }

  public Map<Integer, String> selectAll(Connection conn) throws SQLException {
    String sql = "SELECT * FROM position";

    try (PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery()) {

      Map<Integer, String> positions = new HashMap<>();

      while (rs.next()) {
        int code = rs.getInt("position_code");
        String name = rs.getString("position_name");
        positions.put(code, name);
      }

      return positions;
    }
  }
}
