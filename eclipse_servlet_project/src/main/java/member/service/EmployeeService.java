package member.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.connection.ConnectionProvider;
import member.dao.EmployeeDao;
import member.model.Employee;

public class EmployeeService {
    private EmployeeDao employeeDao = new EmployeeDao();

	public Employee getEmployee(int code) {
		try (Connection conn = ConnectionProvider.getConnection()) {
			Employee employee = employeeDao.selectByCode(conn, code);
			
			return employee;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
