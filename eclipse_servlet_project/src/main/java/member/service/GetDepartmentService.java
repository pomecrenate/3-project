package member.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import exception.DepartmentNotFoundException;
import jdbc.connection.ConnectionProvider;
import member.dao.DepartmentDao;

public class GetDepartmentService {
  // DepartmentDao 객체 생성
  // DepartmentDaoオブジェクト作成
  private DepartmentDao departmentDao = new DepartmentDao();

  // 모든 부서 정보를 가져오는 메서드
  //すべての部門情報を取得するメソッド
  public Map<Integer, String> get() {
    try (Connection conn = ConnectionProvider.getConnection()) {
      // departmentDao.selectAll를 이용해서 모든 부서를 가져와 Map에 저장
      // department Dao.selectAllを利用してすべての部署を持ってきてMapに保存
      Map<Integer, String> departments = departmentDao.selectAll(conn);

      // 가져온 부서가 없으면 예외를 던짐
      // 持ってきた部署がなければ例外を投げる
      if (departments.isEmpty()) {
        throw new DepartmentNotFoundException();
      }

      // 가져온 부서를 반환
      // 持ってきた部署を返却
      return departments;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
