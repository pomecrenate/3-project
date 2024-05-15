package member.service;

import java.sql.Connection;
import java.sql.SQLException;
import exception.EmployeeNotFoundException;
import jdbc.connection.ConnectionProvider;
import member.dao.EmployeeDao;
import member.model.Employee;

public class GetEmployeeService {
  // EmployeeDao 객체 생성
  // EmployeeDaoオブジェクト作成	
  private EmployeeDao employeeDao = new EmployeeDao();

  // 코드를 통해 직원 정보를 가져오는 메서드
  //コードを介して従業員情報を取得するメソッド
  public Employee get(int code) {
    try (Connection conn = ConnectionProvider.getConnection()) {
      // employeeDao.selectByCode를 이용해서 코드로 직원 정보를 가져 employee에 저장.
      // employeeDao.selectByCodeを利用してコードで職員情報を持ってemployeeに保存
      Employee employee = employeeDao.selectByCode(conn, code);

      // 가져온 직원이 없으면 예외를 던짐
      // 持ってきた職員がいなければ例外を投げる
      if (employee == null) {
        throw new EmployeeNotFoundException();
      }

      // 가져온 직원을 반환
      // 持参した職員を返却
      return employee;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
