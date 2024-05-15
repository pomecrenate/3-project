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
  // BusinessItem 코드로 BusinessItem을 조회하는 메서드
  // BusinessItemコードでBusinessItemを照会するメソッド
  public BusinessItem selectByCode(Connection conn, int code) throws SQLException {
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    System.out.println("business item code: " + code);

    try {
      pstmt = conn.prepareStatement("SELECT * FROM business_item WHERE business_item_code = ?");
      pstmt.setInt(1, code);
      rs = pstmt.executeQuery();

      BusinessItem businessItem = null;

      // ResultSet에서 결과를 추출하여 BusinessItem 객체 생성
      // ResultSetから結果を抽出してBusiness Itemオブジェクトを作成
      if (rs.next()) {
        int businessItemCode = rs.getInt("business_item_code");
        String businessItemName = rs.getString("business_item_name");

        businessItem = new BusinessItem(businessItemCode, businessItemName);
      }

      // 생성된 BusinessItem 객체 반환
      // 生成されたBusiness Itemオブジェクトの返却
      return businessItem;
    } finally {
      JdbcUtil.close(rs);
      JdbcUtil.close(pstmt);
    }
  }

  // 모든 비즈니스 아이템을 조회하는 메서드
  //すべてのビジネス アイテムを照会するメソッド
  public Map<Integer, String> selectAll(Connection conn) throws SQLException {
    String sql = "SELECT * FROM business_item";

    try (PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery()) {

      // 비즈니스 아이템을 저장할 Map 객체 생성
      // ビジネスアイテムを保存するMapオブジェクト作成
      Map<Integer, String> businessItems = new HashMap<>();

      // ResultSet에서 결과를 추출하여 Map에 저장
      // ResultSetから結果を抽出し、Mapに保存
      while (rs.next()) {
        int code = rs.getInt("business_item_code");
        String name = rs.getString("business_item_name");
        businessItems.put(code, name);
      }

      return businessItems;
    }
  }
}
