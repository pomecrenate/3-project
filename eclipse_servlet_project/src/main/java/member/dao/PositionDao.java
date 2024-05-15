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
  // 직책 코드로 직책 정보를 조회하는 메서드
  // 役職コードで役職情報を照会するメソッド
  public Position selectByCode(Connection conn, int code) throws SQLException {
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    System.out.println("position code: " + code); 

    try {
      pstmt = conn.prepareStatement("SELECT * FROM position WHERE position_code = ?");
      pstmt.setInt(1, code);
      rs = pstmt.executeQuery();

      Position position = null;

      if (rs.next()) {
        // 조회된 직책 정보를 추출하여 객체로 생성
    	// 照会された役職情報を抽出してオブジェクトに生成
        int positionCode = rs.getInt("position_code");
        String positionName = rs.getString("position_name");

        position = new Position(positionCode, positionName);
      }

      return position; // 조회된 직책 객체 반환
      				   // 照会された役職オブジェクトの返却
    } finally {
      JdbcUtil.close(rs);
      JdbcUtil.close(pstmt);
    }
  }

  // 모든 직책 정보를 조회하는 메서드
  // すべての役職情報を照会するメソッド
  public Map<Integer, String> selectAll(Connection conn) throws SQLException {
    String sql = "SELECT * FROM position";

    try (PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery()) {

      Map<Integer, String> positions = new HashMap<>();

      while (rs.next()) {
        // 조회된 직책 정보를 맵에 추가
    	// 照会された役職情報をマップに追加
        int code = rs.getInt("position_code");
        String name = rs.getString("position_name");
        positions.put(code, name);
      }

      return positions; // 모든 직책 정보를 담은 맵 반환
      				    // すべての役職情報を含むマップの返却
    }
  }
}
