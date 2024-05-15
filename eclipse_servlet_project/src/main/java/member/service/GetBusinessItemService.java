package member.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import exception.BusinessItemNotFoundException;
import jdbc.connection.ConnectionProvider;
import member.dao.BusinessItemDao;

public class GetBusinessItemService {
  // BusinessItemDao 객체 생성
  // Business ItemDaoオブジェクト作成
  private BusinessItemDao businessItemDao = new BusinessItemDao();

  // 비즈니스 아이템 목록을 반환하는 메서드
  //ビジネス アイテムのリストを返すメソッド
  public Map<Integer, String> get() {
    try (Connection conn = ConnectionProvider.getConnection()) {
      // businessItemDao의 selectAll 사용하여 모든 비즈니스 아이템을 가져와 Map에 저장
      // businessItemDaoのselectAllを使用してすべてのビジネスアイテムを持ってきてMapに保存
      Map<Integer, String> businessItems = businessItemDao.selectAll(conn);

      // 가져온 비즈니스 아이템이 비어 있는 경우 예외를 던짐
      // インポートされたビジネス アイテムが空の場合の例外を投げる
      if (businessItems.isEmpty()) {
        throw new BusinessItemNotFoundException();
      }

      // 비어 있지 않은 경우 비즈니스 아이템 목록 반환
      // 空いていない場合は、ビジネス アイテム リストの返却
      return businessItems;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
