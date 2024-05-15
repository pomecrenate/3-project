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
  //businessTypeCode로 businessType을 조회하는 메서드
  // businessType Codeで businessTypeを照会するメソッド
  public BusinessType selectByCode(Connection conn, int code) throws SQLException {
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    System.out.println("business type code: " + code);

    try {
      pstmt = conn.prepareStatement("SELECT * FROM business_type WHERE business_type_code = ?");
      pstmt.setInt(1, code);
      rs = pstmt.executeQuery();

      BusinessType businessType = null;

      // ResultSet에서 결과를 추출하여 BusinessType 객체 생성
      // ResultSetから結果を抽出してBusiness Typeオブジェクトを生成
      if (rs.next()) {
        int businessTypeCode = rs.getInt("business_type_code");
        String businessTypeName = rs.getString("business_type_name");

        businessType = new BusinessType(businessTypeCode, businessTypeName);
      }

      // 생성된 BusinessType 객체 반환
      // 生成されたBusiness Typeオブジェクトの返却
      return businessType;
    } finally {
      JdbcUtil.close(rs);
      JdbcUtil.close(pstmt);
    }
  }

  // 모든 businessType을 조회하는 메서드
  // すべてのbusiness Typeを照会するメソッド
  public Map<Integer, String> selectAll(Connection conn) throws SQLException {
    String sql = "SELECT * FROM business_type";

    try (PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery()) {

      // businessType을 저장할 Map 객체 생성
      // business Typeを保存するMapオブジェクト作成
      Map<Integer, String> businessTypes = new HashMap<>();

      // ResultSet에서 결과를 추출하여 Map에 저장
      // ResultSetから結果を抽出し、Mapに保存
      while (rs.next()) {
        int code = rs.getInt("business_type_code");
        String name = rs.getString("business_type_name");
        businessTypes.put(code, name);
      }

      // 생성된 Map 객체 반환
      // 生成されたMapオブジェクトの返却
      return businessTypes;
    }
  }
}
