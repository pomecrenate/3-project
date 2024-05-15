package member.service;

import java.sql.Connection;

import java.sql.SQLException;
import java.util.List;

import jdbc.connection.ConnectionProvider;
import member.dao.EmployeeDao;
import member.model.Employee;
// 수정 기능 작업 시 직원 정보를 가져와 목록에 저장
// 修正機能作業時に社員の情報を取得してリストに保存
public class ModifyListService {
	
	private static EmployeeDao employeeDao = new EmployeeDao();
	
	// 직원의 정보를 가져와 리스트로 반환하는 메서드
	// 従業員の情報をインポートしてリストに返すメソッド
	public static List<Employee> selectModifyList(int code){
		try (Connection conn = ConnectionProvider.getConnection()){
			
			// EmployeeDao를 이용해서 수정할 직원의 정보를 가져와 리스트로 반환
			// EmployeeDaoを利用して修正する職員の情報を持ってきてリストに返却
			return employeeDao.selectModifyList(conn, code);
		}catch (SQLException e) {
			throw new RuntimeException("Failed to retrieve Employee Info.", e);
		}
	}
}
