package member.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import exception.BusinessTypeNotFoundException;
import jdbc.connection.ConnectionProvider;
import member.dao.BusinessTypeDao;

public class GetBusinessTypeService {
  // BusinessTypeDao 객체를 생성
  // Business TypeDaoオブジェクトを作成	
  private BusinessTypeDao businessTypeDao = new BusinessTypeDao();

  // 업태의 전체 목록을 반환하는 메서드
  //業態の全リストを返すメソッド
  public Map<Integer, String> get() {
    try (Connection conn = ConnectionProvider.getConnection()) {
      // businessTypeDao.selectAlo를 사용하여 모든 업태를 가져옴
      // business Type Dao.select Aloを使用してすべての業態を持ってくる
      Map<Integer, String> businessTypes = businessTypeDao.selectAll(conn);

      // 가져온 업태가 비어 있는 경우 예외를 던짐.
      // インポートした業態が空の場合の例外を投げる
      if (businessTypes.isEmpty()) {
        throw new BusinessTypeNotFoundException();
      }

      // 비어 있지 않은 경우 업태 목록을 반환.
      // 空いていない場合は、業態リストを返却
      return businessTypes;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
