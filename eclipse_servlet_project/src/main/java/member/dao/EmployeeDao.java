package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    public EmployeeDao() {
        this.companyDao = new CompanyDao();
        this.departmentDao = new DepartmentDao();
        this.positionDao = new PositionDao();
    }

    public Employee selectByCode(Connection conn, int code) throws SQLException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;

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
                LocalDate leavingDate = rs.getTimestamp("leaving_date").toLocalDateTime().toLocalDate();
                int birthNumber = rs.getInt("birth_number");
                int residentNumber = rs.getInt("resident_number");
                String address = rs.getString("address");
                String phoneNumber = rs.getString("phone_number");
                String email = rs.getString("email");

                employee = new Employee(employeeCode, company, department, position, employeeName,
                        employmentType, hireDate, leavingDate, birthNumber, residentNumber,
                        address, phoneNumber, email);
            }

            return employee;
        } finally {
            JdbcUtil.close(rs);
            JdbcUtil.close(pstmt);
        }
    }
    
    public List<Employee> selectBasicInfo(Connection conn) throws SQLException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Employee> employees = new ArrayList<>();

        try {
            pstmt = conn.prepareStatement("SELECT employee_code, employee_name, department_code, position_code, hire_date FROM employee");
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
