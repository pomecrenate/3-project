package member.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.connection.ConnectionProvider;
import member.dao.EmployeeDao;

public class DeleteService {
    
    private EmployeeDao employeeDao;
    
    // DeleteService의 생성자
    // Delete Serviceの作成者
    public DeleteService() {
        this.employeeDao = new EmployeeDao();
    }

    
     // 직원을 삭제하는 메서드
     // 職員を削除するメソッド
    public void deleteEmployee(int employeeCode) throws SQLException {
        try (Connection conn = ConnectionProvider.getConnection()) {
            // employeeDao을 통해 직원 삭제
        	// employeeDaoを通じて職員を削除
            employeeDao.deleteEmployee(conn, employeeCode);
        } catch (SQLException e) {
            throw e;
        }
    }
}
