package member.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import member.dao.CompanyDao;
import member.dao.DepartmentDao;
import member.dao.EmployeeDao;
import member.dao.PositionDao;
import member.model.BusinessItem;
import member.model.BusinessType;
import member.model.Company;
import member.model.Department;
import member.model.Employee;
import member.model.Position;

public class RegisterService {
	private EmployeeDao employeeDao = new EmployeeDao();
	CompanyDao companyDao = new CompanyDao();
	DepartmentDao departmentDao = new DepartmentDao();
	PositionDao positionDao = new PositionDao();

	public void Register(RegisterRequest registerRequest) {
		Connection conn = null;

		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
		
			String companyId = registerRequest.getCompanyId();
			
			Company company = companyDao.selectById(conn, companyId);
			int departmentCode = registerRequest.getDepartmentCode();
			Department department = departmentDao.selectByCode(conn, departmentCode);
			int positionCode = registerRequest.getPositionCode();
			Position position = positionDao.selectByCode(conn, positionCode);
			String employeeName = registerRequest.getEmployeeName();
			String employmentType = registerRequest.getEmploymentType();
			String address = registerRequest.getAddress();
            String phoneNumber = registerRequest.getPhoneNumber();
            String email = registerRequest.getEmail();
            int birthNumber = registerRequest.getBirthNumber();
            int residentNumber = registerRequest.getResidentNumber();
            LocalDate hireDate = registerRequest.getHireDate();

            Employee employeeRegister = new Employee(company, department, position, employeeName, employmentType,
                    address, phoneNumber, email, birthNumber, residentNumber, hireDate);

            //신규 사원 등록
            employeeDao.insert(conn, employeeRegister);
			
			conn.commit();

		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(conn);
		}
	}
}