package member.service; 
 
import java.sql.Connection; 
import java.sql.SQLException; 
 
import jdbc.connection.ConnectionProvider; 
import member.dao.EmployeeDao; 
 
public class DeleteService { 
     
    private EmployeeDao employeeDao; 
 
    public DeleteService() { 
        this.employeeDao = new EmployeeDao(); 
    } 
 
    public void deleteEmployee(int employeeCode) throws SQLException { 
        try (Connection conn = ConnectionProvider.getConnection()) { 
            employeeDao.deleteEmployee(conn, employeeCode); 
        } catch (SQLException e) { 
            throw e; 
        } 
    } 
} 
