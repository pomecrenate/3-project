package member.service; 
 
import java.sql.Connection; 
import java.sql.SQLException; 
import java.util.List; 
 
import jdbc.connection.ConnectionProvider; 
import member.dao.EmployeeDao; 
import member.model.Employee; 
 
public class DeleteListService { 
 
    private static EmployeeDao employeeDao = new EmployeeDao(); 
 
    public static List<Employee> getDeleteList(int code) { 
        try (Connection conn = ConnectionProvider.getConnection()) { 
            return employeeDao.selectDeleteList(conn, code); 
        } catch (SQLException e) { 
            throw new RuntimeException("Failed to retrieve employee information", e); 
        } 
    } 
 
} 
