package member.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import jdbc.connection.ConnectionProvider;
import member.dao.EmployeeDao;
import member.model.Employee;

public class ModifyListService {
	
	private static EmployeeDao employeeDao = new EmployeeDao();
	
	public static List<Employee> selectModifyList(int code){
		try (Connection conn = ConnectionProvider.getConnection()){
			return employeeDao.selectModifyList(conn, code);
		}catch (SQLException e) {
			throw new RuntimeException("Failed to retrieve Employee Info.", e);
		}
	}
}
