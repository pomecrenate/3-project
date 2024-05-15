package member.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import exception.PositionNotFoundException;
import jdbc.connection.ConnectionProvider;
import member.dao.PositionDao;

public class GetPositionService {
  // PositionDao 객체 생성
  // PositionDaoオブジェクト作成
  private PositionDao positionDao = new PositionDao();

  // 모든 직위 정보를 가져오는 메서드
  //すべての役職情報を取得するメソッド 
  public Map<Integer, String> get() {
    try (Connection conn = ConnectionProvider.getConnection()) {
      // positionDao.selectAll를 이용해서 모든 직위를 가져와 Map에 저장
      // positionDao.selectAllを利用してすべての職位を持ってきてMapに保存
      Map<Integer, String> positions = positionDao.selectAll(conn);

      // 가져온 직위가 없으면 예외를 던짐
      // 持ってきた職位がなければ例外を投げる
      if (positions.isEmpty()) {
        throw new PositionNotFoundException();
      }

      // 가져온 직위를 반환
      // 持ち込んだ職位の返還
      return positions;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
