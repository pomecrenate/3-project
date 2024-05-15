package member.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import jdbc.connection.ConnectionProvider;
import member.dao.EmployeeDao;
import member.model.Employee;

public class DeleteListService {

    private static EmployeeDao employeeDao = new EmployeeDao();

    // 회사 코드를 기준으로 삭제 대상 직원 목록을 가져오는 메서드
    // 会社コードに基づいて削除対象従業員のリストを取得するメソッド
    public static List<Employee> getDeleteList(int code) {
        try (Connection conn = ConnectionProvider.getConnection()) {
            // employeeDao을 통해 삭제 대상 직원 목록 조회
        	// employeeDaoを通じて削除対象職員リストを照会
            return employeeDao.selectDeleteList(conn, code);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to retrieve employee information", e);
        }
    }

}
