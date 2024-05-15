package member.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

import exception.EmployeeNotFoundException;
import jdbc.connection.ConnectionProvider;
import member.dao.EmployeeDao;

public class EmploymentTypeService {
    // EmployeeDao 객체 생성
	// EmployeeDaoオブジェクト作成
    private EmployeeDao employeeDao = new EmployeeDao();

    // 회사의 고용 형태를 가져오는 메서드
    // 会社の雇用形態をもたらすメソッド
    public Map<String, Integer> get(int companyCode) {
        try (Connection conn = ConnectionProvider.getConnection()) {
            // employeeDao의 employmentType메서드를 통해 직원의 고용 형태를 가져와 Map의 저장
        	// employeeDaoのemployment Typeメソッドを通じて職員の雇用形態を持ってきてMapの保存
            Map<String, Integer> typeCount = employeeDao.employmentType(conn, companyCode);

            // 고용 형태가 없는 경우 예외 발생
            // 雇用形態がない場合、例外発生
            if (typeCount.isEmpty()) {
                throw new EmployeeNotFoundException();
            }
            return typeCount;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
