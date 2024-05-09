package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jdbc.JdbcUtil;
import member.model.BusinessItem;
import member.model.BusinessType;
import member.model.Company;
import member.model.Department;
import member.model.Employee;
import member.model.Position;

public class EmployeeDao {
	public Employee selectByCode(Connection conn, int code) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		Employee employee = null;
		CompanyDao companyDao = null;
		DepartmentDao departmentDao = null;
		PositionDao positionDao = null;

		try {
			pstmt = conn.prepareStatement("select * from employee where employee_code = ?");
			pstmt.setInt(1, code);
		      rs = pstmt.executeQuery();

			if (rs.next()) {
			    int employeeCode = rs.getInt("employee_code");
			    int companyCode = rs.getInt("company_code");
			    Company company = companyDao.selectByCode(conn, companyCode);
			    int departmentCode = rs.getInt("department_code");
			    Department department = departmentDao.selectByCode(conn, departmentCode);
			    int positionCode = rs.getInt("position_code");
			    Position position = positionDao.selectByCode(conn, positionCode);
			    String employeeName = rs.getString("employee_name");
			    String employmentType = rs.getString("employment_type");
			    String address = rs.getString("address");
			    String phoneNumber = rs.getString("phone_number");
			    String email = rs.getString("email");
			    int birthNumber = rs.getInt("birth_number");
			    int residentNumber = rs.getInt("resident_number");
			    LocalDate hireDate = rs.getTimestamp("hire_date").toLocalDateTime().toLocalDate();
			    LocalDate leavingDate = rs.getTimestamp("leaving_date").toLocalDateTime().toLocalDate();
			    String status = rs.getString("status");

			    employee = new Employee(employeeCode, company, department, position, employeeName, employmentType, hireDate, leavingDate, birthNumber, residentNumber, address, phoneNumber, email, status);
			}

			return employee;

		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
}
