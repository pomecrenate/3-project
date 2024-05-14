package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jdbc.JdbcUtil;
import member.model.Company;
import member.model.Department;
import member.model.Employee;
import member.model.Position;

public class EmployeeDao {
	private CompanyDao companyDao;
	private DepartmentDao departmentDao;
	private PositionDao positionDao;

	// コンストラクタ
	public EmployeeDao() {
		this.companyDao = new CompanyDao();
		this.departmentDao = new DepartmentDao();
		this.positionDao = new PositionDao();
	}

	// 従業員コードで検索して取得するメソッド
	public Employee selectByCode(Connection conn, int code) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		System.out.println("employee code: " + code);
		
		try {
			pstmt = conn.prepareStatement("select * from employee where employee_code = ?");
			pstmt.setInt(1, code);
			rs = pstmt.executeQuery();

			Employee employee = null;

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
				LocalDate hireDate = rs.getTimestamp("hire_date").toLocalDateTime().toLocalDate();
				int birthNumber = rs.getInt("birth_number");
				int residentNumber = rs.getInt("resident_number");
				String address = rs.getString("address");
				String phoneNumber = rs.getString("phone_number");
				String email = rs.getString("email");

				employee = new Employee(employeeCode, company, department, position, employeeName, employmentType,
						hireDate, birthNumber, residentNumber, address, phoneNumber, email);
			}
			

			
			return employee;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}

	// modifyEmployeeInfo
	public List<Employee> selectModifyList(Connection conn, int code)throws SQLException{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Employee> employees = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement("select employee_code, department_code, position_code, employee_name, employment_type, hire_date from employee where company_code = ?");
			pstmt.setInt(1, code);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int employeeCode = rs.getInt("employee_code");
				int departmentCode = rs.getInt("department_code");
				Department department = departmentDao.selectByCode(conn, departmentCode);
				int positionCode = rs.getInt("position_code");
				Position position = positionDao.selectByCode(conn, positionCode);
				String employeeName = rs.getString("employee_name");
				String employmentType = rs.getString("employment_type");
				LocalDate hireDate = rs.getTimestamp("hire_date").toLocalDateTime().toLocalDate();
				
				Employee employee = new Employee();
				employee.setEmployeeCode(employeeCode);
				employee.setDepartment(department);
				employee.setPosition(position);
				employee.setEmployeeName(employeeName);
				employee.setEmploymentType(employmentType);
				employee.setHireDate(hireDate);
				
				employees.add(employee);
			}
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		
		return employees;
	}
	
	// 基本情報を取得するメソッド
	public List<Employee> selectDeleteList(Connection conn, int code) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Employee> employees = new ArrayList<>();

		try {
			pstmt = conn.prepareStatement(
					"SELECT employee_code, employee_name, department_code, position_code, hire_date FROM employee where company_code = ?");
			pstmt.setInt(1, code);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int employeeCode = rs.getInt("employee_code");
				String employeeName = rs.getString("employee_name");
				int departmentCode = rs.getInt("department_code");
				Department department = departmentDao.selectByCode(conn, departmentCode);
				int positionCode = rs.getInt("position_code");
				Position position = positionDao.selectByCode(conn, positionCode);
				LocalDate hireDate = rs.getTimestamp("hire_date").toLocalDateTime().toLocalDate();

				Employee employee = new Employee();
				employee.setEmployeeCode(employeeCode);
				employee.setEmployeeName(employeeName);
				employee.setDepartment(department);
				employee.setPosition(position);
				employee.setHireDate(hireDate);

				employees.add(employee);
			}
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}

		return employees;
	}
    public int update(Connection conn, Employee employee) throws SQLException {
	    String sql = "UPDATE employee "
	        + "SET department_code = ?, position_code = ?, "
	        + "employee_name = ?, employment_type = ?, address = ?, phone_number = ?, email = ?, "
	        + "hire_date = ? " 
	        + "where employee_code = ?";
	    
	    System.out.println("UPDATEemployeName: " + employee.getEmployeeName());

	    
	    try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
	      pstmt.setInt(1, employee.getDepartment().getDepartmentCode());
	      pstmt.setInt(2, employee.getPosition().getPositionCode());
	      pstmt.setString(3, employee.getEmployeeName());
	      pstmt.setString(4, employee.getEmploymentType());
	      pstmt.setString(5, employee.getAddress());
	      pstmt.setString(6, employee.getPhoneNumber());
	      pstmt.setString(7, employee.getEmail());
	      pstmt.setTimestamp(8, Timestamp.valueOf(employee.getHireDate().atStartOfDay()));
	      pstmt.setInt(9, employee.getEmployeeCode());

	      return pstmt.executeUpdate();
	    }
	  }

	// 従業員を削除するメソッド
	public void deleteEmployee(Connection conn, int code) throws SQLException {
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement("DELETE FROM employee WHERE employee_code = ?");
			pstmt.setInt(1, code);
			pstmt.executeUpdate();
		} finally {
			JdbcUtil.close(pstmt);
		}
	}

}
