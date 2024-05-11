package member.service; 
 
import java.sql.Connection; 
import java.sql.SQLException; 
import java.util.List; 
 
import jdbc.connection.ConnectionProvider; 
import member.dao.EmployeeDao; 
import member.model.Employee; 
 
public class RetirementService { 
 
    private static EmployeeDao employeeDao = new EmployeeDao(); 
 
    public static List<Employee> getAllEmployeesBasicInfo() { 
        try (Connection conn = ConnectionProvider.getConnection()) { 
            return employeeDao.selectBasicInfo(conn); 
        } catch (SQLException e) { 
            throw new RuntimeException("Failed to retrieve employee information", e); 
        } 
    } 
 
    public void retireEmployee(int employeeCode) { 
        try (Connection conn = ConnectionProvider.getConnection()) { 
            employeeDao.deleteEmployee(conn, employeeCode); 
        } catch (SQLException e) { 
            throw new RuntimeException("Failed to retire employee", e); 
        } 
    } 
} 
